package laughedelic.atom.ide.scala

import scala.scalajs.js, js.annotation._
import laughedelic.atom.ide.ui.busysignal.BusySignalService
import laughedelic.atom.packagedeps.packageDeps

// NOTE: This is pure boilerplate. We need it because we can"t simply say `module.exports = new ScalaLanguageClient();`
object Exports {
  private val client = new ScalaLanguageClient()

  @JSExportTopLevel("config")
  val config = Config.init("ide-scala")
  client.getLogger().debug(js.JSON.stringify(config, space = 2))

  @JSExportTopLevel("activate")
  def activate(): Unit = {
    packageDeps.install("ide-scala", showPrompt = false)
    client.activate()
  }
  @JSExportTopLevel("deactivate")
  def deactivate(): js.Promise[js.Any] = client.deactivate()

  // Provider services
  @JSExportTopLevel("provideOutlines")
  def provideOutlines(): js.Any = client.provideOutlines()
  @JSExportTopLevel("provideDefinitions")
  def provideDefinitions(): js.Any = client.provideDefinitions()
  @JSExportTopLevel("provideCodeHighlight")
  def provideCodeHighlight(): js.Any = client.provideCodeHighlight()
  @JSExportTopLevel("provideFindReferences")
  def provideFindReferences(): js.Any = client.provideFindReferences()
  @JSExportTopLevel("provideCodeFormat")
  def provideCodeFormat(): js.Any = client.provideCodeFormat()
  @JSExportTopLevel("provideCodeActions")
  def provideCodeActions(): js.Any = client.provideCodeActions()
  @JSExportTopLevel("provideAutocomplete")
  def provideAutocomplete(): js.Any = client.provideAutocomplete()

  // Consumer services
  @JSExportTopLevel("consumeDatatip")
  def consumeDatatip(service: js.Any): Unit = client.consumeDatatip(service)
  @JSExportTopLevel("consumeLinterV2")
  def consumeLinterV2(registerIndie: js.Any): Unit = client.consumeLinterV2(registerIndie)
  @JSExportTopLevel("consumeBusySignal")
  def consumeBusySignal(service: BusySignalService): Unit = client.consumeBusySignal(service)
  @JSExportTopLevel("consumeSignatureHelp")
  def consumeSignatureHelp(registry: js.Any): js.Any = client.consumeSignatureHelp(registry)

}
