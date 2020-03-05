package io.cucumber.htmlformatter;

import io.cucumber.messages.Messages;
import io.cucumber.messages.NdjsonToMessageIterable;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(args[0]);
        OutputStreamWriter writer = new OutputStreamWriter(fileOutputStream);
        MessagesToHtmlWriter htmlWriter = new MessagesToHtmlWriter(writer);

        NdjsonToMessageIterable envelopes = new NdjsonToMessageIterable(System.in);

        for (Messages.Envelope envelope : envelopes) {
            htmlWriter.write(envelope);
        }
    }

}
