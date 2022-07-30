"use strict";
$('#university').on('change', function () {
    const university = $('#university').val();
    const carrer = $('#carrer');
    let unam = ["Historia", "Turismo", "Letras"];
    let dachary = ["Derecho", "Arquitectura", "Contabilidad"];
    switch (university) {
        case '1':
            carrer.html('<option value="no">Selecciona una carrera</option>');
            $.each(unam, function (i, val) {
                carrer.append("<option value=" + i + ">" + val + "</option>");
            });
            break;
        case '2':
            carrer.html('<option value="no">Selecciona una carrera</option>');
            $.each(dachary, function (i, val) {
                carrer.append("<option value=" + i + ">" + val + "</option>");
            });
            break;
        default:
            carrer.html('<option>Selecciona una carrera</option>');
            break;
    }
});
