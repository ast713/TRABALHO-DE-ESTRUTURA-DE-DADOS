// Função para buscar o cliente pelo CPF e exibir suas informações
function buscarCliente() {
    var cpfBusca = document.getElementById('buscarCPF').value;
    var clienteEncontrado = tabelaHash[cpfBusca];

    var resultadoDiv = document.getElementById('resultadoBusca');

    if (clienteEncontrado) {
        resultadoDiv.innerHTML = ''; // Limpa o conteúdo anterior

        // Cria elementos para exibir as informações do cliente
        var nomeParagrafo = document.createElement('p');
        nomeParagrafo.textContent = 'Nome: ' + clienteEncontrado.getNome();

        var emailParagrafo = document.createElement('p');
        emailParagrafo.textContent = 'Email: ' + clienteEncontrado.getEmail();

        var telefoneParagrafo = document.createElement('p');
        telefoneParagrafo.textContent = 'Telefone: ' + clienteEncontrado.getTelefone();

        // Verifica se o cliente optou por receber promoções via e-mail
        var promocoesParagrafo = document.createElement('p');
        promocoesParagrafo.textContent = 'Receber promoções via e-mail: ' + (clienteEncontrado.isReceberPromocoes() ? 'Sim' : 'Não');

        // Adiciona os parágrafos à div de resultado
        resultadoDiv.appendChild(nomeParagrafo);
        resultadoDiv.appendChild(emailParagrafo);
        resultadoDiv.appendChild(telefoneParagrafo);
        resultadoDiv.appendChild(promocoesParagrafo);
    } else {
        resultadoDiv.innerHTML = 'Cliente não encontrado!';
    }
}
