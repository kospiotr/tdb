import { TdbGuiPage } from './app.po';

describe('tdb-gui App', () => {
  let page: TdbGuiPage;

  beforeEach(() => {
    page = new TdbGuiPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
