/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statistics.matcher;

import java.util.ArrayList;



/**
 *
 * @author cocacoca
 */
public class KyselyBuilderi {

    private ArrayList<Matcher> matchers;

    public KyselyBuilderi() {
        alusta();
    }

    public void alusta() {
        this.matchers = new ArrayList();
    }

    public KyselyBuilderi playsIn(String team) {
        matchers.add(new PlaysIn(team));
        return this;
    }

    public KyselyBuilderi hasAtLeast(int score, String category) {
        matchers.add(new HasAtLeast(score, category));
        return this;
    }

    public KyselyBuilderi hasFewerThan(int score, String category) {
        matchers.add(new HasFewerThan(score, category));
        return this;
    }

    public KyselyBuilderi oneOf(Matcher... params) {
        matchers.add(new Or(params));
        return this;
    }

    public Matcher[] getMatchers(ArrayList<Matcher> matchers) {
        Matcher[] newMatchers = new Matcher[matchers.size()];
        newMatchers = matchers.toArray(newMatchers);
        return newMatchers;
    }

    public Matcher build() {
        ArrayList<Matcher> matcherit = matchers;
        alusta();
        return new And(getMatchers(matcherit));
    }
}
