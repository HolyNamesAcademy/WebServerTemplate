import Phaser from 'phaser';

// This is the core "scene" that calls all other scenes.
class Game extends Phaser.Scene {
  constructor() {
    super('game');
  }

  init() {}

  create() {
    this.add.image(100, 200, 'charby');
  }

  update() {}
}

export default Game;
