package com.task.websearch.service;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.task.websearch.utils.TestShouldProcessOnlyStartPage;
import com.task.websearch.utils.TestShouldProcessOnlyStartPageWhenMaxUrlCountTwo;
import com.task.websearch.utils.TestShouldProcessTwoPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.task.websearch.utils.TestShouldProcessOnlyStartPage.getStartPageBody;
import static com.task.websearch.utils.TestShouldProcessOnlyStartPage.getTestInitialModelForOneLinkProcess;
import static com.task.websearch.utils.TestShouldProcessOnlyStartPageWhenMaxUrlCountTwo.getStartPageBodyWithoutLinks;
import static com.task.websearch.utils.TestShouldProcessOnlyStartPageWhenMaxUrlCountTwo.getTestInitialModelForOneLinkProcessWhenExpectTwo;
import static com.task.websearch.utils.TestShouldProcessTwoPage.getSecondPageBody;
import static com.task.websearch.utils.TestShouldProcessTwoPage.getTestInitialModelForTwoLinkProcess;
import static com.task.websearch.utils.TestShouldSendMessageWithErrorStatus.*;
import static com.task.websearch.utils.TestShouldThrowIllegalArgumentException.getTestInitialDataModelForExc;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class SearchServiceTest {

    @InjectMocks
    SearchService searchService;

    private WireMockServer wireMockServer;

    @Before
    public void configureWireMockServer() {
        this.wireMockServer = new WireMockServer();
        this.wireMockServer.start();
    }

    @After
    public void stopWireMockServer() {
        this.wireMockServer.stop();
    }

    @Test
    public void shouldSendMessageWithErrorStatus() {
        var session = mock(WebSocketSession.class);
        try {

            doNothing().when(session).sendMessage(new TextMessage(getFirstMessage()));
            doNothing().when(session).sendMessage(new TextMessage(getSecondMessage()));
            when(session.isOpen()).thenReturn(true).thenReturn(false);
            doNothing().when(session).close();

            searchService.processData(getTestInitialDataModel(), session);

            verify(session, timeout(5000).times(1))
                    .sendMessage(new TextMessage(getFirstMessage()));
            verify(session, timeout(5000).times(1))
                    .sendMessage(new TextMessage(getSecondMessage()));
            verify(session, timeout(5000).times(2)).isOpen();
            verify(session, timeout(5000).times(1)).close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentException() {
        var session = mock(WebSocketSession.class);
        searchService.processData(getTestInitialDataModelForExc(), session);
    }

    @Test
    public void shouldProcessOnlyStartPage() {

        stubFor(get("https://ua.woodoos.com/woodoos-ua/ukrazom/").willReturn(aResponse()
                .withStatus(200)
                .withBody(getStartPageBody())));

        var session = mock(WebSocketSession.class);

        try {
            doNothing().when(session).sendMessage(new TextMessage(TestShouldProcessOnlyStartPage.getFirstMessage()));
            doNothing().when(session).sendMessage(new TextMessage(TestShouldProcessOnlyStartPage.getSecondMessage()));
            doNothing().when(session).sendMessage(new TextMessage(TestShouldProcessOnlyStartPage.getThirdMessage()));
            when(session.isOpen()).thenReturn(true).thenReturn(false);
            doNothing().when(session).close();

            searchService.processData(getTestInitialModelForOneLinkProcess(), session);

            verify(session, timeout(5000).times(1))
                    .sendMessage(new TextMessage(TestShouldProcessOnlyStartPage.getFirstMessage()));
            verify(session, timeout(5000).times(1))
                    .sendMessage(new TextMessage(TestShouldProcessOnlyStartPage.getSecondMessage()));
            verify(session, timeout(5000).times(1))
                    .sendMessage(new TextMessage(TestShouldProcessOnlyStartPage.getThirdMessage()));
            verify(session, timeout(5000).times(2)).isOpen();
            verify(session, timeout(5000).times(1)).close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void shouldProcessTwoStartPage() {

        stubFor(get("https://ua.woodoos.com/woodoos-ua/ukrazom/").willReturn(aResponse()
                .withStatus(200)
                .withBody(getStartPageBody())));

        stubFor(get("https://www.ukrazom.org/").willReturn(aResponse()
                .withStatus(200)
                .withBody(getSecondPageBody())));

        var session = mock(WebSocketSession.class);

        try {
            doNothing().when(session).sendMessage(new TextMessage(TestShouldProcessTwoPage.getFirstMessage()));
            doNothing().when(session).sendMessage(new TextMessage(TestShouldProcessTwoPage.getSecondMessage()));
            doNothing().when(session).sendMessage(new TextMessage(TestShouldProcessTwoPage.getThirdMessage()));
            doNothing().when(session).sendMessage(new TextMessage(TestShouldProcessTwoPage.getFourthMessage()));
            doNothing().when(session).sendMessage(new TextMessage(TestShouldProcessTwoPage.getFifthMessage()));
            doNothing().when(session).sendMessage(new TextMessage(TestShouldProcessTwoPage.getSixthMessage()));
            when(session.isOpen()).thenReturn(true).thenReturn(false);
            doNothing().when(session).close();

            searchService.processData(getTestInitialModelForTwoLinkProcess(), session);

            verify(session, timeout(5000).times(1))
                    .sendMessage(new TextMessage(TestShouldProcessTwoPage.getFirstMessage()));
            verify(session, timeout(5000).times(1))
                    .sendMessage(new TextMessage(TestShouldProcessTwoPage.getSecondMessage()));
            verify(session, timeout(5000).times(1))
                    .sendMessage(new TextMessage(TestShouldProcessTwoPage.getThirdMessage()));
            verify(session, timeout(5000).times(1))
                    .sendMessage(new TextMessage(TestShouldProcessTwoPage.getFourthMessage()));
            verify(session, timeout(5000).times(1))
                    .sendMessage(new TextMessage(TestShouldProcessTwoPage.getFifthMessage()));
            verify(session, timeout(5000).times(1))
                    .sendMessage(new TextMessage(TestShouldProcessTwoPage.getSixthMessage()));
            verify(session, timeout(5000).times(2)).isOpen();
            verify(session, timeout(5000).times(1)).close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void shouldTestShouldProcessOnlyStartPageWhenMaxUrlCountTwo() {

        stubFor(get("https://ua.woodoos.com/woodoos-ua/ukrazom/").willReturn(aResponse()
                .withStatus(200)
                .withBody(getStartPageBodyWithoutLinks())));

        var session = mock(WebSocketSession.class);

        try {
            doNothing().when(session)
                    .sendMessage(new TextMessage(TestShouldProcessOnlyStartPageWhenMaxUrlCountTwo.getFirstMessage()));
            doNothing().when(session)
                    .sendMessage(new TextMessage(TestShouldProcessOnlyStartPageWhenMaxUrlCountTwo.getSecondMessage()));
            doNothing().when(session)
                    .sendMessage(new TextMessage(TestShouldProcessOnlyStartPageWhenMaxUrlCountTwo.getThirdMessage()));
            when(session.isOpen()).thenReturn(true).thenReturn(false);
            doNothing().when(session).close();

            searchService.processData(getTestInitialModelForOneLinkProcessWhenExpectTwo(), session);

            verify(session, timeout(5000).times(1))
                    .sendMessage(new TextMessage(TestShouldProcessOnlyStartPageWhenMaxUrlCountTwo.getFirstMessage()));
            verify(session, timeout(5000).times(1))
                    .sendMessage(new TextMessage(TestShouldProcessOnlyStartPageWhenMaxUrlCountTwo.getSecondMessage()));
            verify(session, timeout(5000).times(1))
                    .sendMessage(new TextMessage(TestShouldProcessOnlyStartPageWhenMaxUrlCountTwo.getThirdMessage()));
            verify(session, timeout(5000).times(2)).isOpen();
            verify(session, timeout(5000).times(1)).close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}