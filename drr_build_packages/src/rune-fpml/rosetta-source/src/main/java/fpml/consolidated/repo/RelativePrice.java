package fpml.consolidated.repo;

import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.Multi;
import com.rosetta.model.lib.annotations.Required;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.util.ListEquals;
import fpml.consolidated.repo.meta.RelativePriceMeta;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A type which represents Pricing relative to a Benchmark.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type which represents Pricing relative to a Benchmark.
 *
 */
@RosettaDataType(value="RelativePrice", builder=RelativePrice.RelativePriceBuilderImpl.class, version="2.1.1")
@RuneDataType(value="RelativePrice", model="fpml", builder=RelativePrice.RelativePriceBuilderImpl.class, version="2.1.1")
public interface RelativePrice extends RosettaModelObject {

	RelativePriceMeta metaData = new RelativePriceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Basis Point spread over a Benchmark.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Basis Point spread over a Benchmark.
	 *
	 */
	BigDecimal getSpread();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision 
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	List<? extends RelativePriceChoice> getRelativePriceChoice();

	/*********************** Build Methods  ***********************/
	RelativePrice build();
	
	RelativePrice.RelativePriceBuilder toBuilder();
	
	static RelativePrice.RelativePriceBuilder builder() {
		return new RelativePrice.RelativePriceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends RelativePrice> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends RelativePrice> getType() {
		return RelativePrice.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("spread"), BigDecimal.class, getSpread(), this);
		processRosetta(path.newSubPath("relativePriceChoice"), processor, RelativePriceChoice.class, getRelativePriceChoice());
	}
	

	/*********************** Builder Interface  ***********************/
	interface RelativePriceBuilder extends RelativePrice, RosettaModelObjectBuilder {
		RelativePriceChoice.RelativePriceChoiceBuilder getOrCreateRelativePriceChoice(int index);
		@Override
		List<? extends RelativePriceChoice.RelativePriceChoiceBuilder> getRelativePriceChoice();
		RelativePrice.RelativePriceBuilder setSpread(BigDecimal spread);
		RelativePrice.RelativePriceBuilder addRelativePriceChoice(RelativePriceChoice relativePriceChoice);
		RelativePrice.RelativePriceBuilder addRelativePriceChoice(RelativePriceChoice relativePriceChoice, int idx);
		RelativePrice.RelativePriceBuilder addRelativePriceChoice(List<? extends RelativePriceChoice> relativePriceChoice);
		RelativePrice.RelativePriceBuilder setRelativePriceChoice(List<? extends RelativePriceChoice> relativePriceChoice);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("spread"), BigDecimal.class, getSpread(), this);
			processRosetta(path.newSubPath("relativePriceChoice"), processor, RelativePriceChoice.RelativePriceChoiceBuilder.class, getRelativePriceChoice());
		}
		

		RelativePrice.RelativePriceBuilder prune();
	}

	/*********************** Immutable Implementation of RelativePrice  ***********************/
	class RelativePriceImpl implements RelativePrice {
		private final BigDecimal spread;
		private final List<? extends RelativePriceChoice> relativePriceChoice;
		
		protected RelativePriceImpl(RelativePrice.RelativePriceBuilder builder) {
			this.spread = builder.getSpread();
			this.relativePriceChoice = ofNullable(builder.getRelativePriceChoice()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("spread")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("spread")
		public BigDecimal getSpread() {
			return spread;
		}
		
		@Override
		@RosettaAttribute("relativePriceChoice")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("relativePriceChoice")
		public List<? extends RelativePriceChoice> getRelativePriceChoice() {
			return relativePriceChoice;
		}
		
		@Override
		public RelativePrice build() {
			return this;
		}
		
		@Override
		public RelativePrice.RelativePriceBuilder toBuilder() {
			RelativePrice.RelativePriceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(RelativePrice.RelativePriceBuilder builder) {
			ofNullable(getSpread()).ifPresent(builder::setSpread);
			ofNullable(getRelativePriceChoice()).ifPresent(builder::setRelativePriceChoice);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			RelativePrice _that = getType().cast(o);
		
			if (!Objects.equals(spread, _that.getSpread())) return false;
			if (!ListEquals.listEquals(relativePriceChoice, _that.getRelativePriceChoice())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (spread != null ? spread.hashCode() : 0);
			_result = 31 * _result + (relativePriceChoice != null ? relativePriceChoice.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RelativePrice {" +
				"spread=" + this.spread + ", " +
				"relativePriceChoice=" + this.relativePriceChoice +
			'}';
		}
	}

	/*********************** Builder Implementation of RelativePrice  ***********************/
	class RelativePriceBuilderImpl implements RelativePrice.RelativePriceBuilder {
	
		protected BigDecimal spread;
		protected List<RelativePriceChoice.RelativePriceChoiceBuilder> relativePriceChoice = new ArrayList<>();
		
		@Override
		@RosettaAttribute("spread")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("spread")
		public BigDecimal getSpread() {
			return spread;
		}
		
		@Override
		@RosettaAttribute("relativePriceChoice")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("relativePriceChoice")
		public List<? extends RelativePriceChoice.RelativePriceChoiceBuilder> getRelativePriceChoice() {
			return relativePriceChoice;
		}
		
		@Override
		public RelativePriceChoice.RelativePriceChoiceBuilder getOrCreateRelativePriceChoice(int index) {
			if (relativePriceChoice==null) {
				this.relativePriceChoice = new ArrayList<>();
			}
			return getIndex(relativePriceChoice, index, () -> {
						RelativePriceChoice.RelativePriceChoiceBuilder newRelativePriceChoice = RelativePriceChoice.builder();
						return newRelativePriceChoice;
					});
		}
		
		@RosettaAttribute("spread")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("spread")
		@Override
		public RelativePrice.RelativePriceBuilder setSpread(BigDecimal _spread) {
			this.spread = _spread == null ? null : _spread;
			return this;
		}
		
		@RosettaAttribute("relativePriceChoice")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("relativePriceChoice")
		@Override
		public RelativePrice.RelativePriceBuilder addRelativePriceChoice(RelativePriceChoice _relativePriceChoice) {
			if (_relativePriceChoice != null) {
				this.relativePriceChoice.add(_relativePriceChoice.toBuilder());
			}
			return this;
		}
		
		@Override
		public RelativePrice.RelativePriceBuilder addRelativePriceChoice(RelativePriceChoice _relativePriceChoice, int idx) {
			getIndex(this.relativePriceChoice, idx, () -> _relativePriceChoice.toBuilder());
			return this;
		}
		
		@Override
		public RelativePrice.RelativePriceBuilder addRelativePriceChoice(List<? extends RelativePriceChoice> relativePriceChoices) {
			if (relativePriceChoices != null) {
				for (final RelativePriceChoice toAdd : relativePriceChoices) {
					this.relativePriceChoice.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("relativePriceChoice")
		@Accessor(AccessorType.SETTER)
		@Required
		@Multi
		@RuneAttribute("relativePriceChoice")
		@Override
		public RelativePrice.RelativePriceBuilder setRelativePriceChoice(List<? extends RelativePriceChoice> relativePriceChoices) {
			if (relativePriceChoices == null) {
				this.relativePriceChoice = new ArrayList<>();
			} else {
				this.relativePriceChoice = relativePriceChoices.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public RelativePrice build() {
			return new RelativePrice.RelativePriceImpl(this);
		}
		
		@Override
		public RelativePrice.RelativePriceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RelativePrice.RelativePriceBuilder prune() {
			relativePriceChoice = relativePriceChoice.stream().filter(b->b!=null).<RelativePriceChoice.RelativePriceChoiceBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getSpread()!=null) return true;
			if (getRelativePriceChoice()!=null && getRelativePriceChoice().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RelativePrice.RelativePriceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			RelativePrice.RelativePriceBuilder o = (RelativePrice.RelativePriceBuilder) other;
			
			merger.mergeRosetta(getRelativePriceChoice(), o.getRelativePriceChoice(), this::getOrCreateRelativePriceChoice);
			
			merger.mergeBasic(getSpread(), o.getSpread(), this::setSpread);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			RelativePrice _that = getType().cast(o);
		
			if (!Objects.equals(spread, _that.getSpread())) return false;
			if (!ListEquals.listEquals(relativePriceChoice, _that.getRelativePriceChoice())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (spread != null ? spread.hashCode() : 0);
			_result = 31 * _result + (relativePriceChoice != null ? relativePriceChoice.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RelativePriceBuilder {" +
				"spread=" + this.spread + ", " +
				"relativePriceChoice=" + this.relativePriceChoice +
			'}';
		}
	}
}
