/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muni.fi.pa165.liquorbottles.client.swingForms;

import muni.fi.pa165.liquorbottles.api.dto.BottleDTO;
import muni.fi.pa165.liquorbottles.client.rest.BottleRestClient;

/**
 *
 * @author Jakub Lipcak, Masaryk University
 */
public class Main {

    public static void main(String args[]) {
        BottleRestClient bottleRestClient = new BottleRestClient();
        BottleDTO bottle = bottleRestClient.getBottleById(BottleDTO.class, "1");
        System.out.println(bottle);
    }
}