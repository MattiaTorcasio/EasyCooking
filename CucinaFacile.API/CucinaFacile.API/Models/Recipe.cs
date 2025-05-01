namespace CucinaFacile.API.Models
{
    public class Recipe
    {
        public int Id { get; set; }
        public string Name { get; set; }
        public string Ingredients { get; set; }
        public string Steps { get; set; }
        public string ImageUrl { get; set; }
        public int CategoryId { get; set; }
        public string LanguageCode { get; set; }

        public Category Category { get; set; }
    }
}
