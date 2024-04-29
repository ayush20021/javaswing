<?php

// Sample array
$array = array(
    array('form_id' => 12, 'data1' => 'Avc', 'data2' => '5rf'),
    array('form_id' => 12, 'data1' => 'Avc', 'data2' => '5rf'),
    array('form_id' => 12, 'data1' => 'Avc', 'data2' => '5rf'),
    array('form_id' => 14, 'data1' => 'Avc12', 'data2' => '5rf34'),
    array('form_id' => 16, 'data1' => 'Avc12', 'data2' => '5rf34')
);

// Initialize variables to track form_id changes
$currentFormId = null;
$tableStarted = false;

// Iterate through the array
foreach ($array as $item) {
    $formId = $item['form_id'];
    
    // If form_id changes, close previous table and start a new one
    if ($formId != $currentFormId) {
        if ($tableStarted) {
            echo "</table>"; // Close previous table if it was started
        }
        echo "<br/>"; // Print form_id as table heading
        echo "<table border='1'><tr>
        <th>Data1</th>
        <th>Data2</th>
        </tr>";
        $currentFormId = $formId;
        $tableStarted = true;
    }
    
    // Print data1 and data2 in table rows
    echo "<tr>
    <td>".$item['data1']."</td>
    <td>".$item['data2']."</td>
    </tr>";
}

// Close the last table
if ($tableStarted) {
    echo "</table>";
}
?>
