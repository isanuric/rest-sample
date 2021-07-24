package com.isanuric.websample.flower;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FlowerService {

    private static final String BASE_URI = "http://localhost:8080/flower";

    public String getFlowerString() {
        ResponseEntity<String> response = new RestTemplate().getForEntity(
                BASE_URI + "/string-one",
                String.class);
        return response.getBody();
    }

    public byte[] getFlowerByte() {
        try {
            return serialize(getFlowerOne());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return new byte[0];
    }

    public Flower getFlowerOne() throws IOException, ClassNotFoundException {
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Flower> request = new HttpEntity<>(new Flower());
        ResponseEntity<byte[]> response = restTemplate.exchange(
                BASE_URI + "/one",
                HttpMethod.GET,
                request,
                byte[].class);
        return (Flower) deserialize(response.getBody());
    }

    public ResponseEntity<List<Flower>> getFlower() {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.add("flower-header", "DFRTGZTR");

        return restTemplate.exchange(
                "/flower",
                HttpMethod.GET,
                new HttpEntity<>(null, headers),
                new FlowerParameterizedTypeReference()
        );
    }

    public byte[] serialize(Object obj) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(obj);
        return byteArrayOutputStream.toByteArray();
    }
    public Object deserialize(byte[] data) throws IOException, ClassNotFoundException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(data);
        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
        return objectInputStream.readObject();
    }

}


