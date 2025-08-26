README.md – SmartHome Java Patterns Demo
📌 Visão Geral

Este projeto é uma demonstração prática de Padrões de Projeto em Java, desenvolvido para mostrar como organizar um sistema complexo de automação residencial utilizando padrões criacionais, estruturais e comportamentais. A aplicação simula dispositivos inteligentes (como lâmpadas) e regras de automação, integrando diferentes padrões para demonstrar suas funcionalidades e benefícios.

O projeto foi criado no IntelliJ IDEA, utilizando Java 17+ e estruturado como um projeto Maven para facilitar compilação, execução e empacotamento.

📂 Estrutura de Pacotes

A aplicação segue a seguinte árvore de pacotes:

com.smarthome
 ├── Main.java
 ├── common                → Classes base e utilitários
 │    ├── Device.java
 │    ├── Sensor.java
 │    └── Logger.java
 ├── creational
 │    ├── singleton        → ConfigCenter.java (Singleton)
 │    ├── builder          → AutomationRule.java (Builder)
 │    └── factory          → DeviceFactory.java (Factory)
 ├── behavioral
 │    ├── strategy         → SchedulingStrategy.java, DailySchedule.java, WeekendSchedule.java
 │    ├── observer         → EventBus.java, SensorEvent.java
 │    ├── command          → Command.java, TurnOnCommand.java, TurnOffCommand.java, MacroCommand.java, CommandHistory.java, RemoteControl.java
 │    └── templatemethod   → DeviceBootstrap.java, LightBootstrap.java
 ├── structural
 │    ├── adapter          → ThirdPartyHueLight.java, HueLightAdapter.java
 │    ├── decorator        → DeviceDecorator.java, LoggingDeviceDecorator.java
 │    └── facade           → SmartHomeFacade.java

⚙️ Funcionalidades Implementadas
1. Strategy (Agendamento)

Permite definir regras de execução de tarefas, como:

DailySchedule → executa todos os dias.

WeekendSchedule → executa apenas nos finais de semana.

Vantagem: troca de comportamento em tempo de execução sem alterar o código cliente.

2. Template Method (Bootstrap de Dispositivo)

Define a sequência de inicialização de dispositivos (init()) e permite personalizar cada etapa:

connect() → conecta o dispositivo.

configure() → configura parâmetros específicos.

ready() → passo final fixo.

Vantagem: mantém consistência da inicialização, permitindo variações sem quebrar a sequência.

3. Singleton (ConfigCenter)

Mantém uma instância única para configurações globais do sistema, como locale e ambiente.

Vantagem: evita criar múltiplas instâncias desnecessárias e centraliza as configurações.

4. Factory (DeviceFactory)

Cria objetos Device de forma flexível, podendo instanciar diferentes tipos (ex.: lâmpadas, sensores) sem que o cliente conheça a implementação interna.

Vantagem: desacopla a criação de objetos do uso.

5. Builder (AutomationRule)

Cria regras de automação complexas com múltiplos parâmetros opcionais de forma legível e segura.

Vantagem: evita construtores com muitos parâmetros, melhorando legibilidade.

6. Observer (EventBus)

Permite que sensores publiquem eventos (SensorEvent) e que múltiplos ouvintes se inscrevam para recebê-los.

Vantagem: promove baixo acoplamento entre emissor e observadores.

7. Command + Macro + Undo

Comandos encapsulam ações (TurnOnCommand, TurnOffCommand) e podem ser compostos em MacroCommand.

Histórico de execução (CommandHistory) permite desfazer ações (undo).

Vantagem: flexibilidade na execução e reversão de ações complexas.

8. Adapter (HueLightAdapter)

Adapta dispositivos de terceiros (ThirdPartyHueLight) à interface Device.

Vantagem: permite integrar APIs externas sem alterar a estrutura do sistema.

9. Decorator (LoggingDeviceDecorator)

Adiciona funcionalidade extra a dispositivos sem alterar sua implementação, como logs automáticos de liga/desliga.

Vantagem: extensão dinâmica de comportamento.

10. Facade (SmartHomeFacade)

Cria uma interface simplificada para operações complexas:

Ex.: goodMorning() acende múltiplos dispositivos com um único comando.

Vantagem: simplifica o uso do sistema para clientes e integra vários padrões.

🚀 Como Rodar a Aplicação
1. Pelo IntelliJ

Abra Main.java.

Clique com o botão direito no método main → Run 'Main.main()'.

Veja o console na aba Run com o log da execução.

2. Pelo Maven

No terminal, na raiz do projeto:

mvn compile exec:java -Dexec.mainClass="com.smarthome.Main"

3. Empacotando JAR executável

Adicione o plugin maven-shade-plugin no pom.xml.

Rode:

mvn package


Execute:

java -jar target/smart-home-1.0.0-SNAPSHOT-shaded.jar

📖 Fluxo de execução da demo

ConfigCenter inicializa as configurações globais (Singleton).

Factory cria dispositivos e, opcionalmente, decoradores adicionam logging.

Template Method inicializa os dispositivos garantindo sequência correta.

Strategy decide se as regras de automação devem rodar hoje.

Builder cria regras de automação (AutomationRule).

Observer recebe eventos de sensores e distribui aos ouvintes.

Facade executa macros (goodMorning, goodNight) e pode desfazer ações via Command History.

💡 Boas Práticas Aplicadas

Estrutura de pacotes organizada por tipo de padrão.

Classes com uma responsabilidade clara.

Uso correto de interfaces e abstrações para desacoplamento.

Facilita extensibilidade, manutenção e testes unitários.

📌 Observações

Este projeto é didático, focado em demonstrar padrões de projeto em conjunto.

Todos os padrões podem ser testados e integrados no Main.java.

Ideal para estudo, aprendizado ou como base para sistemas de automação mais complexos.

📂 Estrutura de Pacotes e Padrões de Projeto – Visual
com.smarthome                        ← Raiz do projeto

├── Main.java                        ← Integração / Demo
│
├── common                           ← Classes base e utilitários
│    ├── Device.java                 ← Base para todos os dispositivos
│    ├── Sensor.java                 ← Sensores genéricos
│    └── Logger.java                 ← Logging centralizado
│
├── creational                        ← Padrões Criacionais
│    ├── singleton                    ← Singleton
│    │    └── ConfigCenter.java
│    ├── builder                      ← Builder
│    │    └── AutomationRule.java
│    └── factory                      ← Factory Method
│         └── DeviceFactory.java
│
├── behavioral                        ← Padrões Comportamentais
│    ├── strategy                     ← Strategy
│    │    ├── SchedulingStrategy.java
│    │    ├── DailySchedule.java
│    │    └── WeekendSchedule.java
│    ├── observer                     ← Observer
│    │    ├── EventBus.java
│    │    └── SensorEvent.java
│    ├── command                      ← Command / Macro / Undo
│    │    ├── Command.java
│    │    ├── TurnOnCommand.java
│    │    ├── TurnOffCommand.java
│    │    ├── MacroCommand.java
│    │    ├── CommandHistory.java
│    │    └── RemoteControl.java
│    └── templatemethod               ← Template Method
│         ├── DeviceBootstrap.java
│         └── LightBootstrap.java
│
├── structural                        ← Padrões Estruturais
│    ├── adapter                      ← Adapter
│    │    ├── ThirdPartyHueLight.java
│    │    └── HueLightAdapter.java
│    ├── decorator                    ← Decorator
│    │    ├── DeviceDecorator.java
│    │    └── LoggingDeviceDecorator.java
│    └── facade                       ← Facade
│         └── SmartHomeFacade.java

📌 Legenda dos Padrões
Pacote / Classe	Padrão Aplicado	Propósito
creational.singleton.ConfigCenter	Singleton	Garantir instância única para configurações globais
creational.builder.AutomationRule	Builder	Criar regras complexas de automação de forma legível
creational.factory.DeviceFactory	Factory Method	Criar objetos Device sem expor implementação
behavioral.strategy.*	Strategy	Diferentes regras de agendamento podem ser trocadas
behavioral.templatemethod.*	Template Method	Sequência fixa de inicialização com etapas customizáveis
behavioral.observer.*	Observer	Envio e recebimento de eventos de sensores
behavioral.command.*	Command / Macro / Undo	Encapsula ações, permite desfazer e agrupar comandos
structural.adapter.*	Adapter	Adapta dispositivos externos à interface Device
structural.decorator.*	Decorator	Extende comportamento de Device (ex.: logging)
structural.facade.SmartHomeFacade	Facade	Interface simplificada para operar múltiplos dispositivos
💡 Como usar visualmente

Cada linha indica um pacote ou classe e o padrão de projeto aplicado.

Serve como guia rápido para saber onde cada padrão está implementado.

Pode ser incluído diretamente no README como referência visual ou em apresentações didáticas.
