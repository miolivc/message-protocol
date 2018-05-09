# message-protocol

Protocolo que define o envio de uma mensagem de texto com Marshaller/Unmarshaller (Builder Pattern), com tamanho máximo de envio de 1024 bytes, onde o primeiro byte indica o multiplicador relacionado ao tamanho da mensagem e o segundo qual será seu tamanho. O primeiro byte que recebe esse multiplicador é utilizado de forma a informar se essa mensagem é uma parte ou está inteira (possui continuídade). Os demais 1022 bytes são utilizados para armazenar a representação em bytes do corpo da mensagem (texto). 
