package fpml.consolidated.riskdef;

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
import fpml.consolidated.riskdef.meta.ValuationScenarioMeta;
import fpml.consolidated.shared.IdentifiedDate;
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
 * Provision A set of rules for generating a valuation.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A set of rules for generating a valuation.
 *
 */
@RosettaDataType(value="ValuationScenario", builder=ValuationScenario.ValuationScenarioBuilderImpl.class, version="2.1.1")
@RuneDataType(value="ValuationScenario", model="fpml", builder=ValuationScenario.ValuationScenarioBuilderImpl.class, version="2.1.1")
public interface ValuationScenario extends RosettaModelObject {

	ValuationScenarioMeta metaData = new ValuationScenarioMeta();

	/*********************** Getter Methods  ***********************/
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
	String getId();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The (optional) name for this valuation scenario, used for understandability. For example "EOD Valuations".
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The (optional) name for this valuation scenario, used for understandability. For example "EOD Valuations".
	 *
	 */
	String getName();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The date for which the assets are valued.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The date for which the assets are valued.
	 *
	 */
	IdentifiedDate getValuationDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A reference to the market environment used to price the asset.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A reference to the market environment used to price the asset.
	 *
	 */
	MarketReference getMarketReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A collection of shifts to be applied to market inputs prior to computation of the derivative.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A collection of shifts to be applied to market inputs prior to computation of the derivative.
	 *
	 */
	List<? extends PricingParameterShift> getShift();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A collection of shifts to be applied to market inputs prior to computation of the derivative.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A collection of shifts to be applied to market inputs prior to computation of the derivative.
	 *
	 */
	List<? extends PricingInputReplacement> getReplacement();

	/*********************** Build Methods  ***********************/
	ValuationScenario build();
	
	ValuationScenario.ValuationScenarioBuilder toBuilder();
	
	static ValuationScenario.ValuationScenarioBuilder builder() {
		return new ValuationScenario.ValuationScenarioBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ValuationScenario> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ValuationScenario> getType() {
		return ValuationScenario.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processor.processBasic(path.newSubPath("name"), String.class, getName(), this);
		processRosetta(path.newSubPath("valuationDate"), processor, IdentifiedDate.class, getValuationDate());
		processRosetta(path.newSubPath("marketReference"), processor, MarketReference.class, getMarketReference());
		processRosetta(path.newSubPath("shift"), processor, PricingParameterShift.class, getShift());
		processRosetta(path.newSubPath("replacement"), processor, PricingInputReplacement.class, getReplacement());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ValuationScenarioBuilder extends ValuationScenario, RosettaModelObjectBuilder {
		IdentifiedDate.IdentifiedDateBuilder getOrCreateValuationDate();
		@Override
		IdentifiedDate.IdentifiedDateBuilder getValuationDate();
		MarketReference.MarketReferenceBuilder getOrCreateMarketReference();
		@Override
		MarketReference.MarketReferenceBuilder getMarketReference();
		PricingParameterShift.PricingParameterShiftBuilder getOrCreateShift(int index);
		@Override
		List<? extends PricingParameterShift.PricingParameterShiftBuilder> getShift();
		PricingInputReplacement.PricingInputReplacementBuilder getOrCreateReplacement(int index);
		@Override
		List<? extends PricingInputReplacement.PricingInputReplacementBuilder> getReplacement();
		ValuationScenario.ValuationScenarioBuilder setId(String id);
		ValuationScenario.ValuationScenarioBuilder setName(String name);
		ValuationScenario.ValuationScenarioBuilder setValuationDate(IdentifiedDate valuationDate);
		ValuationScenario.ValuationScenarioBuilder setMarketReference(MarketReference marketReference);
		ValuationScenario.ValuationScenarioBuilder addShift(PricingParameterShift shift);
		ValuationScenario.ValuationScenarioBuilder addShift(PricingParameterShift shift, int idx);
		ValuationScenario.ValuationScenarioBuilder addShift(List<? extends PricingParameterShift> shift);
		ValuationScenario.ValuationScenarioBuilder setShift(List<? extends PricingParameterShift> shift);
		ValuationScenario.ValuationScenarioBuilder addReplacement(PricingInputReplacement replacement);
		ValuationScenario.ValuationScenarioBuilder addReplacement(PricingInputReplacement replacement, int idx);
		ValuationScenario.ValuationScenarioBuilder addReplacement(List<? extends PricingInputReplacement> replacement);
		ValuationScenario.ValuationScenarioBuilder setReplacement(List<? extends PricingInputReplacement> replacement);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processor.processBasic(path.newSubPath("name"), String.class, getName(), this);
			processRosetta(path.newSubPath("valuationDate"), processor, IdentifiedDate.IdentifiedDateBuilder.class, getValuationDate());
			processRosetta(path.newSubPath("marketReference"), processor, MarketReference.MarketReferenceBuilder.class, getMarketReference());
			processRosetta(path.newSubPath("shift"), processor, PricingParameterShift.PricingParameterShiftBuilder.class, getShift());
			processRosetta(path.newSubPath("replacement"), processor, PricingInputReplacement.PricingInputReplacementBuilder.class, getReplacement());
		}
		

		ValuationScenario.ValuationScenarioBuilder prune();
	}

	/*********************** Immutable Implementation of ValuationScenario  ***********************/
	class ValuationScenarioImpl implements ValuationScenario {
		private final String id;
		private final String name;
		private final IdentifiedDate valuationDate;
		private final MarketReference marketReference;
		private final List<? extends PricingParameterShift> shift;
		private final List<? extends PricingInputReplacement> replacement;
		
		protected ValuationScenarioImpl(ValuationScenario.ValuationScenarioBuilder builder) {
			this.id = builder.getId();
			this.name = builder.getName();
			this.valuationDate = ofNullable(builder.getValuationDate()).map(f->f.build()).orElse(null);
			this.marketReference = ofNullable(builder.getMarketReference()).map(f->f.build()).orElse(null);
			this.shift = ofNullable(builder.getShift()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.replacement = ofNullable(builder.getReplacement()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("name")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("name")
		public String getName() {
			return name;
		}
		
		@Override
		@RosettaAttribute("valuationDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("valuationDate")
		public IdentifiedDate getValuationDate() {
			return valuationDate;
		}
		
		@Override
		@RosettaAttribute("marketReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("marketReference")
		public MarketReference getMarketReference() {
			return marketReference;
		}
		
		@Override
		@RosettaAttribute("shift")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("shift")
		public List<? extends PricingParameterShift> getShift() {
			return shift;
		}
		
		@Override
		@RosettaAttribute("replacement")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("replacement")
		public List<? extends PricingInputReplacement> getReplacement() {
			return replacement;
		}
		
		@Override
		public ValuationScenario build() {
			return this;
		}
		
		@Override
		public ValuationScenario.ValuationScenarioBuilder toBuilder() {
			ValuationScenario.ValuationScenarioBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ValuationScenario.ValuationScenarioBuilder builder) {
			ofNullable(getId()).ifPresent(builder::setId);
			ofNullable(getName()).ifPresent(builder::setName);
			ofNullable(getValuationDate()).ifPresent(builder::setValuationDate);
			ofNullable(getMarketReference()).ifPresent(builder::setMarketReference);
			ofNullable(getShift()).ifPresent(builder::setShift);
			ofNullable(getReplacement()).ifPresent(builder::setReplacement);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ValuationScenario _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(name, _that.getName())) return false;
			if (!Objects.equals(valuationDate, _that.getValuationDate())) return false;
			if (!Objects.equals(marketReference, _that.getMarketReference())) return false;
			if (!ListEquals.listEquals(shift, _that.getShift())) return false;
			if (!ListEquals.listEquals(replacement, _that.getReplacement())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (name != null ? name.hashCode() : 0);
			_result = 31 * _result + (valuationDate != null ? valuationDate.hashCode() : 0);
			_result = 31 * _result + (marketReference != null ? marketReference.hashCode() : 0);
			_result = 31 * _result + (shift != null ? shift.hashCode() : 0);
			_result = 31 * _result + (replacement != null ? replacement.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ValuationScenario {" +
				"id=" + this.id + ", " +
				"name=" + this.name + ", " +
				"valuationDate=" + this.valuationDate + ", " +
				"marketReference=" + this.marketReference + ", " +
				"shift=" + this.shift + ", " +
				"replacement=" + this.replacement +
			'}';
		}
	}

	/*********************** Builder Implementation of ValuationScenario  ***********************/
	class ValuationScenarioBuilderImpl implements ValuationScenario.ValuationScenarioBuilder {
	
		protected String id;
		protected String name;
		protected IdentifiedDate.IdentifiedDateBuilder valuationDate;
		protected MarketReference.MarketReferenceBuilder marketReference;
		protected List<PricingParameterShift.PricingParameterShiftBuilder> shift = new ArrayList<>();
		protected List<PricingInputReplacement.PricingInputReplacementBuilder> replacement = new ArrayList<>();
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("name")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("name")
		public String getName() {
			return name;
		}
		
		@Override
		@RosettaAttribute("valuationDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("valuationDate")
		public IdentifiedDate.IdentifiedDateBuilder getValuationDate() {
			return valuationDate;
		}
		
		@Override
		public IdentifiedDate.IdentifiedDateBuilder getOrCreateValuationDate() {
			IdentifiedDate.IdentifiedDateBuilder result;
			if (valuationDate!=null) {
				result = valuationDate;
			}
			else {
				result = valuationDate = IdentifiedDate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("marketReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("marketReference")
		public MarketReference.MarketReferenceBuilder getMarketReference() {
			return marketReference;
		}
		
		@Override
		public MarketReference.MarketReferenceBuilder getOrCreateMarketReference() {
			MarketReference.MarketReferenceBuilder result;
			if (marketReference!=null) {
				result = marketReference;
			}
			else {
				result = marketReference = MarketReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("shift")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("shift")
		public List<? extends PricingParameterShift.PricingParameterShiftBuilder> getShift() {
			return shift;
		}
		
		@Override
		public PricingParameterShift.PricingParameterShiftBuilder getOrCreateShift(int index) {
			if (shift==null) {
				this.shift = new ArrayList<>();
			}
			return getIndex(shift, index, () -> {
						PricingParameterShift.PricingParameterShiftBuilder newShift = PricingParameterShift.builder();
						return newShift;
					});
		}
		
		@Override
		@RosettaAttribute("replacement")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("replacement")
		public List<? extends PricingInputReplacement.PricingInputReplacementBuilder> getReplacement() {
			return replacement;
		}
		
		@Override
		public PricingInputReplacement.PricingInputReplacementBuilder getOrCreateReplacement(int index) {
			if (replacement==null) {
				this.replacement = new ArrayList<>();
			}
			return getIndex(replacement, index, () -> {
						PricingInputReplacement.PricingInputReplacementBuilder newReplacement = PricingInputReplacement.builder();
						return newReplacement;
					});
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public ValuationScenario.ValuationScenarioBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("name")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("name")
		@Override
		public ValuationScenario.ValuationScenarioBuilder setName(String _name) {
			this.name = _name == null ? null : _name;
			return this;
		}
		
		@RosettaAttribute("valuationDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("valuationDate")
		@Override
		public ValuationScenario.ValuationScenarioBuilder setValuationDate(IdentifiedDate _valuationDate) {
			this.valuationDate = _valuationDate == null ? null : _valuationDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("marketReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("marketReference")
		@Override
		public ValuationScenario.ValuationScenarioBuilder setMarketReference(MarketReference _marketReference) {
			this.marketReference = _marketReference == null ? null : _marketReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("shift")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("shift")
		@Override
		public ValuationScenario.ValuationScenarioBuilder addShift(PricingParameterShift _shift) {
			if (_shift != null) {
				this.shift.add(_shift.toBuilder());
			}
			return this;
		}
		
		@Override
		public ValuationScenario.ValuationScenarioBuilder addShift(PricingParameterShift _shift, int idx) {
			getIndex(this.shift, idx, () -> _shift.toBuilder());
			return this;
		}
		
		@Override
		public ValuationScenario.ValuationScenarioBuilder addShift(List<? extends PricingParameterShift> shifts) {
			if (shifts != null) {
				for (final PricingParameterShift toAdd : shifts) {
					this.shift.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("shift")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("shift")
		@Override
		public ValuationScenario.ValuationScenarioBuilder setShift(List<? extends PricingParameterShift> shifts) {
			if (shifts == null) {
				this.shift = new ArrayList<>();
			} else {
				this.shift = shifts.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("replacement")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("replacement")
		@Override
		public ValuationScenario.ValuationScenarioBuilder addReplacement(PricingInputReplacement _replacement) {
			if (_replacement != null) {
				this.replacement.add(_replacement.toBuilder());
			}
			return this;
		}
		
		@Override
		public ValuationScenario.ValuationScenarioBuilder addReplacement(PricingInputReplacement _replacement, int idx) {
			getIndex(this.replacement, idx, () -> _replacement.toBuilder());
			return this;
		}
		
		@Override
		public ValuationScenario.ValuationScenarioBuilder addReplacement(List<? extends PricingInputReplacement> replacements) {
			if (replacements != null) {
				for (final PricingInputReplacement toAdd : replacements) {
					this.replacement.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("replacement")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("replacement")
		@Override
		public ValuationScenario.ValuationScenarioBuilder setReplacement(List<? extends PricingInputReplacement> replacements) {
			if (replacements == null) {
				this.replacement = new ArrayList<>();
			} else {
				this.replacement = replacements.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public ValuationScenario build() {
			return new ValuationScenario.ValuationScenarioImpl(this);
		}
		
		@Override
		public ValuationScenario.ValuationScenarioBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ValuationScenario.ValuationScenarioBuilder prune() {
			if (valuationDate!=null && !valuationDate.prune().hasData()) valuationDate = null;
			if (marketReference!=null && !marketReference.prune().hasData()) marketReference = null;
			shift = shift.stream().filter(b->b!=null).<PricingParameterShift.PricingParameterShiftBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			replacement = replacement.stream().filter(b->b!=null).<PricingInputReplacement.PricingInputReplacementBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getId()!=null) return true;
			if (getName()!=null) return true;
			if (getValuationDate()!=null && getValuationDate().hasData()) return true;
			if (getMarketReference()!=null && getMarketReference().hasData()) return true;
			if (getShift()!=null && getShift().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getReplacement()!=null && getReplacement().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ValuationScenario.ValuationScenarioBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ValuationScenario.ValuationScenarioBuilder o = (ValuationScenario.ValuationScenarioBuilder) other;
			
			merger.mergeRosetta(getValuationDate(), o.getValuationDate(), this::setValuationDate);
			merger.mergeRosetta(getMarketReference(), o.getMarketReference(), this::setMarketReference);
			merger.mergeRosetta(getShift(), o.getShift(), this::getOrCreateShift);
			merger.mergeRosetta(getReplacement(), o.getReplacement(), this::getOrCreateReplacement);
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			merger.mergeBasic(getName(), o.getName(), this::setName);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ValuationScenario _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(name, _that.getName())) return false;
			if (!Objects.equals(valuationDate, _that.getValuationDate())) return false;
			if (!Objects.equals(marketReference, _that.getMarketReference())) return false;
			if (!ListEquals.listEquals(shift, _that.getShift())) return false;
			if (!ListEquals.listEquals(replacement, _that.getReplacement())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (name != null ? name.hashCode() : 0);
			_result = 31 * _result + (valuationDate != null ? valuationDate.hashCode() : 0);
			_result = 31 * _result + (marketReference != null ? marketReference.hashCode() : 0);
			_result = 31 * _result + (shift != null ? shift.hashCode() : 0);
			_result = 31 * _result + (replacement != null ? replacement.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ValuationScenarioBuilder {" +
				"id=" + this.id + ", " +
				"name=" + this.name + ", " +
				"valuationDate=" + this.valuationDate + ", " +
				"marketReference=" + this.marketReference + ", " +
				"shift=" + this.shift + ", " +
				"replacement=" + this.replacement +
			'}';
		}
	}
}
