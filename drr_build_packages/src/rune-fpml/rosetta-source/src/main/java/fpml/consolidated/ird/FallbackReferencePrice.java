package fpml.consolidated.ird;

import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.Multi;
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
import fpml.consolidated.ird.meta.FallbackReferencePriceMeta;
import fpml.consolidated.shared.CalculationAgent;
import fpml.consolidated.shared.Empty;
import fpml.consolidated.shared.SettlementRateOption;
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
 * Provision The method, prioritzed by the order it is listed in this element, to get a replacement rate for the disrupted settlement rate option.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision The method, prioritzed by the order it is listed in this element, to get a replacement rate for the disrupted settlement rate option.
 *
 */
@RosettaDataType(value="FallbackReferencePrice", builder=FallbackReferencePrice.FallbackReferencePriceBuilderImpl.class, version="2.1.1")
@RuneDataType(value="FallbackReferencePrice", model="fpml", builder=FallbackReferencePrice.FallbackReferencePriceBuilderImpl.class, version="2.1.1")
public interface FallbackReferencePrice extends RosettaModelObject {

	FallbackReferencePriceMeta metaData = new FallbackReferencePriceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies how long to wait to get a quote from a settlement rate option upon a price source disruption
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies how long to wait to get a quote from a settlement rate option upon a price source disruption
	 *
	 */
	ValuationPostponement getValuationPostponement();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision This settlement rate option will be used in its place.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision This settlement rate option will be used in its place.
	 *
	 */
	List<? extends SettlementRateOption> getFallbackSettlementRateOption();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Request rate quotes from the market.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Request rate quotes from the market.
	 *
	 */
	Empty getFallbackSurveyValuationPostponenment();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The calculation agent will decide the rate.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The calculation agent will decide the rate.
	 *
	 */
	CalculationAgent getCalculationAgentDetermination();

	/*********************** Build Methods  ***********************/
	FallbackReferencePrice build();
	
	FallbackReferencePrice.FallbackReferencePriceBuilder toBuilder();
	
	static FallbackReferencePrice.FallbackReferencePriceBuilder builder() {
		return new FallbackReferencePrice.FallbackReferencePriceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FallbackReferencePrice> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FallbackReferencePrice> getType() {
		return FallbackReferencePrice.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("valuationPostponement"), processor, ValuationPostponement.class, getValuationPostponement());
		processRosetta(path.newSubPath("fallbackSettlementRateOption"), processor, SettlementRateOption.class, getFallbackSettlementRateOption());
		processRosetta(path.newSubPath("fallbackSurveyValuationPostponenment"), processor, Empty.class, getFallbackSurveyValuationPostponenment());
		processRosetta(path.newSubPath("calculationAgentDetermination"), processor, CalculationAgent.class, getCalculationAgentDetermination());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FallbackReferencePriceBuilder extends FallbackReferencePrice, RosettaModelObjectBuilder {
		ValuationPostponement.ValuationPostponementBuilder getOrCreateValuationPostponement();
		@Override
		ValuationPostponement.ValuationPostponementBuilder getValuationPostponement();
		SettlementRateOption.SettlementRateOptionBuilder getOrCreateFallbackSettlementRateOption(int index);
		@Override
		List<? extends SettlementRateOption.SettlementRateOptionBuilder> getFallbackSettlementRateOption();
		Empty.EmptyBuilder getOrCreateFallbackSurveyValuationPostponenment();
		@Override
		Empty.EmptyBuilder getFallbackSurveyValuationPostponenment();
		CalculationAgent.CalculationAgentBuilder getOrCreateCalculationAgentDetermination();
		@Override
		CalculationAgent.CalculationAgentBuilder getCalculationAgentDetermination();
		FallbackReferencePrice.FallbackReferencePriceBuilder setValuationPostponement(ValuationPostponement valuationPostponement);
		FallbackReferencePrice.FallbackReferencePriceBuilder addFallbackSettlementRateOption(SettlementRateOption fallbackSettlementRateOption);
		FallbackReferencePrice.FallbackReferencePriceBuilder addFallbackSettlementRateOption(SettlementRateOption fallbackSettlementRateOption, int idx);
		FallbackReferencePrice.FallbackReferencePriceBuilder addFallbackSettlementRateOption(List<? extends SettlementRateOption> fallbackSettlementRateOption);
		FallbackReferencePrice.FallbackReferencePriceBuilder setFallbackSettlementRateOption(List<? extends SettlementRateOption> fallbackSettlementRateOption);
		FallbackReferencePrice.FallbackReferencePriceBuilder setFallbackSurveyValuationPostponenment(Empty fallbackSurveyValuationPostponenment);
		FallbackReferencePrice.FallbackReferencePriceBuilder setCalculationAgentDetermination(CalculationAgent calculationAgentDetermination);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("valuationPostponement"), processor, ValuationPostponement.ValuationPostponementBuilder.class, getValuationPostponement());
			processRosetta(path.newSubPath("fallbackSettlementRateOption"), processor, SettlementRateOption.SettlementRateOptionBuilder.class, getFallbackSettlementRateOption());
			processRosetta(path.newSubPath("fallbackSurveyValuationPostponenment"), processor, Empty.EmptyBuilder.class, getFallbackSurveyValuationPostponenment());
			processRosetta(path.newSubPath("calculationAgentDetermination"), processor, CalculationAgent.CalculationAgentBuilder.class, getCalculationAgentDetermination());
		}
		

		FallbackReferencePrice.FallbackReferencePriceBuilder prune();
	}

	/*********************** Immutable Implementation of FallbackReferencePrice  ***********************/
	class FallbackReferencePriceImpl implements FallbackReferencePrice {
		private final ValuationPostponement valuationPostponement;
		private final List<? extends SettlementRateOption> fallbackSettlementRateOption;
		private final Empty fallbackSurveyValuationPostponenment;
		private final CalculationAgent calculationAgentDetermination;
		
		protected FallbackReferencePriceImpl(FallbackReferencePrice.FallbackReferencePriceBuilder builder) {
			this.valuationPostponement = ofNullable(builder.getValuationPostponement()).map(f->f.build()).orElse(null);
			this.fallbackSettlementRateOption = ofNullable(builder.getFallbackSettlementRateOption()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.fallbackSurveyValuationPostponenment = ofNullable(builder.getFallbackSurveyValuationPostponenment()).map(f->f.build()).orElse(null);
			this.calculationAgentDetermination = ofNullable(builder.getCalculationAgentDetermination()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("valuationPostponement")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("valuationPostponement")
		public ValuationPostponement getValuationPostponement() {
			return valuationPostponement;
		}
		
		@Override
		@RosettaAttribute("fallbackSettlementRateOption")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("fallbackSettlementRateOption")
		public List<? extends SettlementRateOption> getFallbackSettlementRateOption() {
			return fallbackSettlementRateOption;
		}
		
		@Override
		@RosettaAttribute("fallbackSurveyValuationPostponenment")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fallbackSurveyValuationPostponenment")
		public Empty getFallbackSurveyValuationPostponenment() {
			return fallbackSurveyValuationPostponenment;
		}
		
		@Override
		@RosettaAttribute("calculationAgentDetermination")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("calculationAgentDetermination")
		public CalculationAgent getCalculationAgentDetermination() {
			return calculationAgentDetermination;
		}
		
		@Override
		public FallbackReferencePrice build() {
			return this;
		}
		
		@Override
		public FallbackReferencePrice.FallbackReferencePriceBuilder toBuilder() {
			FallbackReferencePrice.FallbackReferencePriceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FallbackReferencePrice.FallbackReferencePriceBuilder builder) {
			ofNullable(getValuationPostponement()).ifPresent(builder::setValuationPostponement);
			ofNullable(getFallbackSettlementRateOption()).ifPresent(builder::setFallbackSettlementRateOption);
			ofNullable(getFallbackSurveyValuationPostponenment()).ifPresent(builder::setFallbackSurveyValuationPostponenment);
			ofNullable(getCalculationAgentDetermination()).ifPresent(builder::setCalculationAgentDetermination);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FallbackReferencePrice _that = getType().cast(o);
		
			if (!Objects.equals(valuationPostponement, _that.getValuationPostponement())) return false;
			if (!ListEquals.listEquals(fallbackSettlementRateOption, _that.getFallbackSettlementRateOption())) return false;
			if (!Objects.equals(fallbackSurveyValuationPostponenment, _that.getFallbackSurveyValuationPostponenment())) return false;
			if (!Objects.equals(calculationAgentDetermination, _that.getCalculationAgentDetermination())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (valuationPostponement != null ? valuationPostponement.hashCode() : 0);
			_result = 31 * _result + (fallbackSettlementRateOption != null ? fallbackSettlementRateOption.hashCode() : 0);
			_result = 31 * _result + (fallbackSurveyValuationPostponenment != null ? fallbackSurveyValuationPostponenment.hashCode() : 0);
			_result = 31 * _result + (calculationAgentDetermination != null ? calculationAgentDetermination.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FallbackReferencePrice {" +
				"valuationPostponement=" + this.valuationPostponement + ", " +
				"fallbackSettlementRateOption=" + this.fallbackSettlementRateOption + ", " +
				"fallbackSurveyValuationPostponenment=" + this.fallbackSurveyValuationPostponenment + ", " +
				"calculationAgentDetermination=" + this.calculationAgentDetermination +
			'}';
		}
	}

	/*********************** Builder Implementation of FallbackReferencePrice  ***********************/
	class FallbackReferencePriceBuilderImpl implements FallbackReferencePrice.FallbackReferencePriceBuilder {
	
		protected ValuationPostponement.ValuationPostponementBuilder valuationPostponement;
		protected List<SettlementRateOption.SettlementRateOptionBuilder> fallbackSettlementRateOption = new ArrayList<>();
		protected Empty.EmptyBuilder fallbackSurveyValuationPostponenment;
		protected CalculationAgent.CalculationAgentBuilder calculationAgentDetermination;
		
		@Override
		@RosettaAttribute("valuationPostponement")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("valuationPostponement")
		public ValuationPostponement.ValuationPostponementBuilder getValuationPostponement() {
			return valuationPostponement;
		}
		
		@Override
		public ValuationPostponement.ValuationPostponementBuilder getOrCreateValuationPostponement() {
			ValuationPostponement.ValuationPostponementBuilder result;
			if (valuationPostponement!=null) {
				result = valuationPostponement;
			}
			else {
				result = valuationPostponement = ValuationPostponement.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("fallbackSettlementRateOption")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("fallbackSettlementRateOption")
		public List<? extends SettlementRateOption.SettlementRateOptionBuilder> getFallbackSettlementRateOption() {
			return fallbackSettlementRateOption;
		}
		
		@Override
		public SettlementRateOption.SettlementRateOptionBuilder getOrCreateFallbackSettlementRateOption(int index) {
			if (fallbackSettlementRateOption==null) {
				this.fallbackSettlementRateOption = new ArrayList<>();
			}
			return getIndex(fallbackSettlementRateOption, index, () -> {
						SettlementRateOption.SettlementRateOptionBuilder newFallbackSettlementRateOption = SettlementRateOption.builder();
						return newFallbackSettlementRateOption;
					});
		}
		
		@Override
		@RosettaAttribute("fallbackSurveyValuationPostponenment")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fallbackSurveyValuationPostponenment")
		public Empty.EmptyBuilder getFallbackSurveyValuationPostponenment() {
			return fallbackSurveyValuationPostponenment;
		}
		
		@Override
		public Empty.EmptyBuilder getOrCreateFallbackSurveyValuationPostponenment() {
			Empty.EmptyBuilder result;
			if (fallbackSurveyValuationPostponenment!=null) {
				result = fallbackSurveyValuationPostponenment;
			}
			else {
				result = fallbackSurveyValuationPostponenment = Empty.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("calculationAgentDetermination")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("calculationAgentDetermination")
		public CalculationAgent.CalculationAgentBuilder getCalculationAgentDetermination() {
			return calculationAgentDetermination;
		}
		
		@Override
		public CalculationAgent.CalculationAgentBuilder getOrCreateCalculationAgentDetermination() {
			CalculationAgent.CalculationAgentBuilder result;
			if (calculationAgentDetermination!=null) {
				result = calculationAgentDetermination;
			}
			else {
				result = calculationAgentDetermination = CalculationAgent.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("valuationPostponement")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("valuationPostponement")
		@Override
		public FallbackReferencePrice.FallbackReferencePriceBuilder setValuationPostponement(ValuationPostponement _valuationPostponement) {
			this.valuationPostponement = _valuationPostponement == null ? null : _valuationPostponement.toBuilder();
			return this;
		}
		
		@RosettaAttribute("fallbackSettlementRateOption")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("fallbackSettlementRateOption")
		@Override
		public FallbackReferencePrice.FallbackReferencePriceBuilder addFallbackSettlementRateOption(SettlementRateOption _fallbackSettlementRateOption) {
			if (_fallbackSettlementRateOption != null) {
				this.fallbackSettlementRateOption.add(_fallbackSettlementRateOption.toBuilder());
			}
			return this;
		}
		
		@Override
		public FallbackReferencePrice.FallbackReferencePriceBuilder addFallbackSettlementRateOption(SettlementRateOption _fallbackSettlementRateOption, int idx) {
			getIndex(this.fallbackSettlementRateOption, idx, () -> _fallbackSettlementRateOption.toBuilder());
			return this;
		}
		
		@Override
		public FallbackReferencePrice.FallbackReferencePriceBuilder addFallbackSettlementRateOption(List<? extends SettlementRateOption> fallbackSettlementRateOptions) {
			if (fallbackSettlementRateOptions != null) {
				for (final SettlementRateOption toAdd : fallbackSettlementRateOptions) {
					this.fallbackSettlementRateOption.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("fallbackSettlementRateOption")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("fallbackSettlementRateOption")
		@Override
		public FallbackReferencePrice.FallbackReferencePriceBuilder setFallbackSettlementRateOption(List<? extends SettlementRateOption> fallbackSettlementRateOptions) {
			if (fallbackSettlementRateOptions == null) {
				this.fallbackSettlementRateOption = new ArrayList<>();
			} else {
				this.fallbackSettlementRateOption = fallbackSettlementRateOptions.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("fallbackSurveyValuationPostponenment")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("fallbackSurveyValuationPostponenment")
		@Override
		public FallbackReferencePrice.FallbackReferencePriceBuilder setFallbackSurveyValuationPostponenment(Empty _fallbackSurveyValuationPostponenment) {
			this.fallbackSurveyValuationPostponenment = _fallbackSurveyValuationPostponenment == null ? null : _fallbackSurveyValuationPostponenment.toBuilder();
			return this;
		}
		
		@RosettaAttribute("calculationAgentDetermination")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("calculationAgentDetermination")
		@Override
		public FallbackReferencePrice.FallbackReferencePriceBuilder setCalculationAgentDetermination(CalculationAgent _calculationAgentDetermination) {
			this.calculationAgentDetermination = _calculationAgentDetermination == null ? null : _calculationAgentDetermination.toBuilder();
			return this;
		}
		
		@Override
		public FallbackReferencePrice build() {
			return new FallbackReferencePrice.FallbackReferencePriceImpl(this);
		}
		
		@Override
		public FallbackReferencePrice.FallbackReferencePriceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FallbackReferencePrice.FallbackReferencePriceBuilder prune() {
			if (valuationPostponement!=null && !valuationPostponement.prune().hasData()) valuationPostponement = null;
			fallbackSettlementRateOption = fallbackSettlementRateOption.stream().filter(b->b!=null).<SettlementRateOption.SettlementRateOptionBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (fallbackSurveyValuationPostponenment!=null && !fallbackSurveyValuationPostponenment.prune().hasData()) fallbackSurveyValuationPostponenment = null;
			if (calculationAgentDetermination!=null && !calculationAgentDetermination.prune().hasData()) calculationAgentDetermination = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValuationPostponement()!=null && getValuationPostponement().hasData()) return true;
			if (getFallbackSettlementRateOption()!=null && getFallbackSettlementRateOption().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getFallbackSurveyValuationPostponenment()!=null && getFallbackSurveyValuationPostponenment().hasData()) return true;
			if (getCalculationAgentDetermination()!=null && getCalculationAgentDetermination().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FallbackReferencePrice.FallbackReferencePriceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FallbackReferencePrice.FallbackReferencePriceBuilder o = (FallbackReferencePrice.FallbackReferencePriceBuilder) other;
			
			merger.mergeRosetta(getValuationPostponement(), o.getValuationPostponement(), this::setValuationPostponement);
			merger.mergeRosetta(getFallbackSettlementRateOption(), o.getFallbackSettlementRateOption(), this::getOrCreateFallbackSettlementRateOption);
			merger.mergeRosetta(getFallbackSurveyValuationPostponenment(), o.getFallbackSurveyValuationPostponenment(), this::setFallbackSurveyValuationPostponenment);
			merger.mergeRosetta(getCalculationAgentDetermination(), o.getCalculationAgentDetermination(), this::setCalculationAgentDetermination);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FallbackReferencePrice _that = getType().cast(o);
		
			if (!Objects.equals(valuationPostponement, _that.getValuationPostponement())) return false;
			if (!ListEquals.listEquals(fallbackSettlementRateOption, _that.getFallbackSettlementRateOption())) return false;
			if (!Objects.equals(fallbackSurveyValuationPostponenment, _that.getFallbackSurveyValuationPostponenment())) return false;
			if (!Objects.equals(calculationAgentDetermination, _that.getCalculationAgentDetermination())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (valuationPostponement != null ? valuationPostponement.hashCode() : 0);
			_result = 31 * _result + (fallbackSettlementRateOption != null ? fallbackSettlementRateOption.hashCode() : 0);
			_result = 31 * _result + (fallbackSurveyValuationPostponenment != null ? fallbackSurveyValuationPostponenment.hashCode() : 0);
			_result = 31 * _result + (calculationAgentDetermination != null ? calculationAgentDetermination.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FallbackReferencePriceBuilder {" +
				"valuationPostponement=" + this.valuationPostponement + ", " +
				"fallbackSettlementRateOption=" + this.fallbackSettlementRateOption + ", " +
				"fallbackSurveyValuationPostponenment=" + this.fallbackSurveyValuationPostponenment + ", " +
				"calculationAgentDetermination=" + this.calculationAgentDetermination +
			'}';
		}
	}
}
