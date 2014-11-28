<%-- 
    Document   : form
    Created on : Nov 27, 2014, 9:52:32 PM
    Author     : Jakub Lipcak, Masaryk University
--%>

<%@ taglib prefix="s" uri="http://stripes.sourceforge.net/stripes.tld" %>
<s:errors/>
<table>
    <tr>
        <th><s:label for="s1" name="police.name"/></th>
        <td><s:text id="s1" name="police.name"/></td>
    </tr>
    <tr>
        <th><s:label for="s2" name="police.address"/></th>
        <td><s:text id="s2" name="police.address"/></td>
    </tr>
    <tr>
        <th><s:label for="s3" name="police.username"/></th>
        <td><s:text id="s3" name="police.username"/></td>
    </tr>
    <tr>
        <th><s:label for="s4" name="police.password"/></th>
        <td><s:text id="s4" name="police.password"/></td>
    </tr>
</table>