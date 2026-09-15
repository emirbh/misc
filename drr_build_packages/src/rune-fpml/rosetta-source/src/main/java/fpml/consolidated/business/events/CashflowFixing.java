package fpml.consolidated.business.events;

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
import fpml.consolidated.business.events.meta.CashflowFixingMeta;
import fpml.consolidated.shared.Rounding;
import fpml.consolidated.shared.Strike;
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
 * Provision Details of the computation of a computed rate or price used to calculate the amount of a cashflow component. This computed rate or price may include averaging and/or various types of rate treatment rules. The details include all of the observations, the calculation parameters, and the resulting value.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision Details of the computation of a computed rate or price used to calculate the amount of a cashflow component. This computed rate or price may include averaging and/or various types of rate treatment rules. The details include all of the observations, the calculation parameters, and the resulting value.
 *
 */
@RosettaDataType(value="CashflowFixing", builder=CashflowFixing.CashflowFixingBuilderImpl.class, version="2.1.1")
@RuneDataType(value="CashflowFixing", model="fpml", builder=CashflowFixing.CashflowFixingBuilderImpl.class, version="2.1.1")
public interface CashflowFixing extends RosettaModelObject {

	CashflowFixingMeta metaData = new CashflowFixingMeta();

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
	 * Provision Reference to the observation details of a particular rate observation.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Reference to the observation details of a particular rate observation.
	 *
	 */
	List<? extends CashflowObservationReference> getObservationReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The value computed based on averaging the underlying observation and applying any spreads, multipliers, and cap and floors values. average or treated value computed based on the underlyer observations, following the calculation rules.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The value computed based on averaging the underlying observation and applying any spreads, multipliers, and cap and floors values. average or treated value computed based on the underlyer observations, following the calculation rules.
	 *
	 */
	BigDecimal getCalculatedValue();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A rate multiplier to apply to the floating rate. The multiplier can be a positive or negative decimal. This element should only be included if the multiplier is not equal to 1 (one).
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A rate multiplier to apply to the floating rate. The multiplier can be a positive or negative decimal. This element should only be included if the multiplier is not equal to 1 (one).
	 *
	 */
	BigDecimal getMultiplier();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The ISDA Spread, if any, which applies for the calculation period. It also defines spread as price. The spread is a per annum rate, expressed as a decimal. For purposes of determining a calculation period amount, if positive the spread will be added to the floating rate and if negative the spread will be subtracted from the floating rate. A positive 10 basis point (0.1%) spread would be represented as 0.001.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The ISDA Spread, if any, which applies for the calculation period. It also defines spread as price. The spread is a per annum rate, expressed as a decimal. For purposes of determining a calculation period amount, if positive the spread will be added to the floating rate and if negative the spread will be subtracted from the floating rate. A positive 10 basis point (0.1%) spread would be represented as 0.001.
	 *
	 */
	BigDecimal getSpread();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The cap rate or price, if any, which applies to the floating rate for the calculation period. The cap rate (strike) is only required where the floating rate on a swap stream is capped at a certain strike level. The cap rate is assumed to be exclusive of any spread and is a per annum rate, expressed as a decimal. A cap rate of 5% would be represented as 0.05.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The cap rate or price, if any, which applies to the floating rate for the calculation period. The cap rate (strike) is only required where the floating rate on a swap stream is capped at a certain strike level. The cap rate is assumed to be exclusive of any spread and is a per annum rate, expressed as a decimal. A cap rate of 5% would be represented as 0.05.
	 *
	 */
	List<? extends Strike> getCapValue();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The floor rate or price, if any, which applies to the floating rate for the calculation period. The floor rate (strike) is only required where the floating rate on a swap stream is floored at a certain strike level. The floor rate is assumed to be exclusive of any spread and is a per annum rate, expressed as a decimal. The floor rate of 5% would be represented as 0.05.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The floor rate or price, if any, which applies to the floating rate for the calculation period. The floor rate (strike) is only required where the floating rate on a swap stream is floored at a certain strike level. The floor rate is assumed to be exclusive of any spread and is a per annum rate, expressed as a decimal. The floor rate of 5% would be represented as 0.05.
	 *
	 */
	List<? extends Strike> getFloorValue();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Flag to indicate if negative interest rate is applied.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Flag to indicate if negative interest rate is applied.
	 *
	 */
	Boolean getNegativeInterestRate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Rounding direction and precision for price values.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Rounding direction and precision for price values.
	 *
	 */
	Rounding getRounding();

	/*********************** Build Methods  ***********************/
	CashflowFixing build();
	
	CashflowFixing.CashflowFixingBuilder toBuilder();
	
	static CashflowFixing.CashflowFixingBuilder builder() {
		return new CashflowFixing.CashflowFixingBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CashflowFixing> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CashflowFixing> getType() {
		return CashflowFixing.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("observationReference"), processor, CashflowObservationReference.class, getObservationReference());
		processor.processBasic(path.newSubPath("calculatedValue"), BigDecimal.class, getCalculatedValue(), this);
		processor.processBasic(path.newSubPath("multiplier"), BigDecimal.class, getMultiplier(), this);
		processor.processBasic(path.newSubPath("spread"), BigDecimal.class, getSpread(), this);
		processRosetta(path.newSubPath("capValue"), processor, Strike.class, getCapValue());
		processRosetta(path.newSubPath("floorValue"), processor, Strike.class, getFloorValue());
		processor.processBasic(path.newSubPath("negativeInterestRate"), Boolean.class, getNegativeInterestRate(), this);
		processRosetta(path.newSubPath("rounding"), processor, Rounding.class, getRounding());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CashflowFixingBuilder extends CashflowFixing, RosettaModelObjectBuilder {
		CashflowObservationReference.CashflowObservationReferenceBuilder getOrCreateObservationReference(int index);
		@Override
		List<? extends CashflowObservationReference.CashflowObservationReferenceBuilder> getObservationReference();
		Strike.StrikeBuilder getOrCreateCapValue(int index);
		@Override
		List<? extends Strike.StrikeBuilder> getCapValue();
		Strike.StrikeBuilder getOrCreateFloorValue(int index);
		@Override
		List<? extends Strike.StrikeBuilder> getFloorValue();
		Rounding.RoundingBuilder getOrCreateRounding();
		@Override
		Rounding.RoundingBuilder getRounding();
		CashflowFixing.CashflowFixingBuilder setId(String id);
		CashflowFixing.CashflowFixingBuilder addObservationReference(CashflowObservationReference observationReference);
		CashflowFixing.CashflowFixingBuilder addObservationReference(CashflowObservationReference observationReference, int idx);
		CashflowFixing.CashflowFixingBuilder addObservationReference(List<? extends CashflowObservationReference> observationReference);
		CashflowFixing.CashflowFixingBuilder setObservationReference(List<? extends CashflowObservationReference> observationReference);
		CashflowFixing.CashflowFixingBuilder setCalculatedValue(BigDecimal calculatedValue);
		CashflowFixing.CashflowFixingBuilder setMultiplier(BigDecimal multiplier);
		CashflowFixing.CashflowFixingBuilder setSpread(BigDecimal spread);
		CashflowFixing.CashflowFixingBuilder addCapValue(Strike capValue);
		CashflowFixing.CashflowFixingBuilder addCapValue(Strike capValue, int idx);
		CashflowFixing.CashflowFixingBuilder addCapValue(List<? extends Strike> capValue);
		CashflowFixing.CashflowFixingBuilder setCapValue(List<? extends Strike> capValue);
		CashflowFixing.CashflowFixingBuilder addFloorValue(Strike floorValue);
		CashflowFixing.CashflowFixingBuilder addFloorValue(Strike floorValue, int idx);
		CashflowFixing.CashflowFixingBuilder addFloorValue(List<? extends Strike> floorValue);
		CashflowFixing.CashflowFixingBuilder setFloorValue(List<? extends Strike> floorValue);
		CashflowFixing.CashflowFixingBuilder setNegativeInterestRate(Boolean negativeInterestRate);
		CashflowFixing.CashflowFixingBuilder setRounding(Rounding rounding);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("observationReference"), processor, CashflowObservationReference.CashflowObservationReferenceBuilder.class, getObservationReference());
			processor.processBasic(path.newSubPath("calculatedValue"), BigDecimal.class, getCalculatedValue(), this);
			processor.processBasic(path.newSubPath("multiplier"), BigDecimal.class, getMultiplier(), this);
			processor.processBasic(path.newSubPath("spread"), BigDecimal.class, getSpread(), this);
			processRosetta(path.newSubPath("capValue"), processor, Strike.StrikeBuilder.class, getCapValue());
			processRosetta(path.newSubPath("floorValue"), processor, Strike.StrikeBuilder.class, getFloorValue());
			processor.processBasic(path.newSubPath("negativeInterestRate"), Boolean.class, getNegativeInterestRate(), this);
			processRosetta(path.newSubPath("rounding"), processor, Rounding.RoundingBuilder.class, getRounding());
		}
		

		CashflowFixing.CashflowFixingBuilder prune();
	}

	/*********************** Immutable Implementation of CashflowFixing  ***********************/
	class CashflowFixingImpl implements CashflowFixing {
		private final String id;
		private final List<? extends CashflowObservationReference> observationReference;
		private final BigDecimal calculatedValue;
		private final BigDecimal multiplier;
		private final BigDecimal spread;
		private final List<? extends Strike> capValue;
		private final List<? extends Strike> floorValue;
		private final Boolean negativeInterestRate;
		private final Rounding rounding;
		
		protected CashflowFixingImpl(CashflowFixing.CashflowFixingBuilder builder) {
			this.id = builder.getId();
			this.observationReference = ofNullable(builder.getObservationReference()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.calculatedValue = builder.getCalculatedValue();
			this.multiplier = builder.getMultiplier();
			this.spread = builder.getSpread();
			this.capValue = ofNullable(builder.getCapValue()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.floorValue = ofNullable(builder.getFloorValue()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.negativeInterestRate = builder.getNegativeInterestRate();
			this.rounding = ofNullable(builder.getRounding()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("observationReference")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("observationReference")
		public List<? extends CashflowObservationReference> getObservationReference() {
			return observationReference;
		}
		
		@Override
		@RosettaAttribute("calculatedValue")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("calculatedValue")
		public BigDecimal getCalculatedValue() {
			return calculatedValue;
		}
		
		@Override
		@RosettaAttribute("multiplier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("multiplier")
		public BigDecimal getMultiplier() {
			return multiplier;
		}
		
		@Override
		@RosettaAttribute("spread")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("spread")
		public BigDecimal getSpread() {
			return spread;
		}
		
		@Override
		@RosettaAttribute("capValue")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("capValue")
		public List<? extends Strike> getCapValue() {
			return capValue;
		}
		
		@Override
		@RosettaAttribute("floorValue")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("floorValue")
		public List<? extends Strike> getFloorValue() {
			return floorValue;
		}
		
		@Override
		@RosettaAttribute("negativeInterestRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("negativeInterestRate")
		public Boolean getNegativeInterestRate() {
			return negativeInterestRate;
		}
		
		@Override
		@RosettaAttribute("rounding")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("rounding")
		public Rounding getRounding() {
			return rounding;
		}
		
		@Override
		public CashflowFixing build() {
			return this;
		}
		
		@Override
		public CashflowFixing.CashflowFixingBuilder toBuilder() {
			CashflowFixing.CashflowFixingBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CashflowFixing.CashflowFixingBuilder builder) {
			ofNullable(getId()).ifPresent(builder::setId);
			ofNullable(getObservationReference()).ifPresent(builder::setObservationReference);
			ofNullable(getCalculatedValue()).ifPresent(builder::setCalculatedValue);
			ofNullable(getMultiplier()).ifPresent(builder::setMultiplier);
			ofNullable(getSpread()).ifPresent(builder::setSpread);
			ofNullable(getCapValue()).ifPresent(builder::setCapValue);
			ofNullable(getFloorValue()).ifPresent(builder::setFloorValue);
			ofNullable(getNegativeInterestRate()).ifPresent(builder::setNegativeInterestRate);
			ofNullable(getRounding()).ifPresent(builder::setRounding);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CashflowFixing _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!ListEquals.listEquals(observationReference, _that.getObservationReference())) return false;
			if (!Objects.equals(calculatedValue, _that.getCalculatedValue())) return false;
			if (!Objects.equals(multiplier, _that.getMultiplier())) return false;
			if (!Objects.equals(spread, _that.getSpread())) return false;
			if (!ListEquals.listEquals(capValue, _that.getCapValue())) return false;
			if (!ListEquals.listEquals(floorValue, _that.getFloorValue())) return false;
			if (!Objects.equals(negativeInterestRate, _that.getNegativeInterestRate())) return false;
			if (!Objects.equals(rounding, _that.getRounding())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (observationReference != null ? observationReference.hashCode() : 0);
			_result = 31 * _result + (calculatedValue != null ? calculatedValue.hashCode() : 0);
			_result = 31 * _result + (multiplier != null ? multiplier.hashCode() : 0);
			_result = 31 * _result + (spread != null ? spread.hashCode() : 0);
			_result = 31 * _result + (capValue != null ? capValue.hashCode() : 0);
			_result = 31 * _result + (floorValue != null ? floorValue.hashCode() : 0);
			_result = 31 * _result + (negativeInterestRate != null ? negativeInterestRate.hashCode() : 0);
			_result = 31 * _result + (rounding != null ? rounding.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CashflowFixing {" +
				"id=" + this.id + ", " +
				"observationReference=" + this.observationReference + ", " +
				"calculatedValue=" + this.calculatedValue + ", " +
				"multiplier=" + this.multiplier + ", " +
				"spread=" + this.spread + ", " +
				"capValue=" + this.capValue + ", " +
				"floorValue=" + this.floorValue + ", " +
				"negativeInterestRate=" + this.negativeInterestRate + ", " +
				"rounding=" + this.rounding +
			'}';
		}
	}

	/*********************** Builder Implementation of CashflowFixing  ***********************/
	class CashflowFixingBuilderImpl implements CashflowFixing.CashflowFixingBuilder {
	
		protected String id;
		protected List<CashflowObservationReference.CashflowObservationReferenceBuilder> observationReference = new ArrayList<>();
		protected BigDecimal calculatedValue;
		protected BigDecimal multiplier;
		protected BigDecimal spread;
		protected List<Strike.StrikeBuilder> capValue = new ArrayList<>();
		protected List<Strike.StrikeBuilder> floorValue = new ArrayList<>();
		protected Boolean negativeInterestRate;
		protected Rounding.RoundingBuilder rounding;
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("observationReference")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("observationReference")
		public List<? extends CashflowObservationReference.CashflowObservationReferenceBuilder> getObservationReference() {
			return observationReference;
		}
		
		@Override
		public CashflowObservationReference.CashflowObservationReferenceBuilder getOrCreateObservationReference(int index) {
			if (observationReference==null) {
				this.observationReference = new ArrayList<>();
			}
			return getIndex(observationReference, index, () -> {
						CashflowObservationReference.CashflowObservationReferenceBuilder newObservationReference = CashflowObservationReference.builder();
						return newObservationReference;
					});
		}
		
		@Override
		@RosettaAttribute("calculatedValue")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("calculatedValue")
		public BigDecimal getCalculatedValue() {
			return calculatedValue;
		}
		
		@Override
		@RosettaAttribute("multiplier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("multiplier")
		public BigDecimal getMultiplier() {
			return multiplier;
		}
		
		@Override
		@RosettaAttribute("spread")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("spread")
		public BigDecimal getSpread() {
			return spread;
		}
		
		@Override
		@RosettaAttribute("capValue")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("capValue")
		public List<? extends Strike.StrikeBuilder> getCapValue() {
			return capValue;
		}
		
		@Override
		public Strike.StrikeBuilder getOrCreateCapValue(int index) {
			if (capValue==null) {
				this.capValue = new ArrayList<>();
			}
			return getIndex(capValue, index, () -> {
						Strike.StrikeBuilder newCapValue = Strike.builder();
						return newCapValue;
					});
		}
		
		@Override
		@RosettaAttribute("floorValue")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("floorValue")
		public List<? extends Strike.StrikeBuilder> getFloorValue() {
			return floorValue;
		}
		
		@Override
		public Strike.StrikeBuilder getOrCreateFloorValue(int index) {
			if (floorValue==null) {
				this.floorValue = new ArrayList<>();
			}
			return getIndex(floorValue, index, () -> {
						Strike.StrikeBuilder newFloorValue = Strike.builder();
						return newFloorValue;
					});
		}
		
		@Override
		@RosettaAttribute("negativeInterestRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("negativeInterestRate")
		public Boolean getNegativeInterestRate() {
			return negativeInterestRate;
		}
		
		@Override
		@RosettaAttribute("rounding")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("rounding")
		public Rounding.RoundingBuilder getRounding() {
			return rounding;
		}
		
		@Override
		public Rounding.RoundingBuilder getOrCreateRounding() {
			Rounding.RoundingBuilder result;
			if (rounding!=null) {
				result = rounding;
			}
			else {
				result = rounding = Rounding.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public CashflowFixing.CashflowFixingBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("observationReference")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("observationReference")
		@Override
		public CashflowFixing.CashflowFixingBuilder addObservationReference(CashflowObservationReference _observationReference) {
			if (_observationReference != null) {
				this.observationReference.add(_observationReference.toBuilder());
			}
			return this;
		}
		
		@Override
		public CashflowFixing.CashflowFixingBuilder addObservationReference(CashflowObservationReference _observationReference, int idx) {
			getIndex(this.observationReference, idx, () -> _observationReference.toBuilder());
			return this;
		}
		
		@Override
		public CashflowFixing.CashflowFixingBuilder addObservationReference(List<? extends CashflowObservationReference> observationReferences) {
			if (observationReferences != null) {
				for (final CashflowObservationReference toAdd : observationReferences) {
					this.observationReference.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("observationReference")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("observationReference")
		@Override
		public CashflowFixing.CashflowFixingBuilder setObservationReference(List<? extends CashflowObservationReference> observationReferences) {
			if (observationReferences == null) {
				this.observationReference = new ArrayList<>();
			} else {
				this.observationReference = observationReferences.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("calculatedValue")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("calculatedValue")
		@Override
		public CashflowFixing.CashflowFixingBuilder setCalculatedValue(BigDecimal _calculatedValue) {
			this.calculatedValue = _calculatedValue == null ? null : _calculatedValue;
			return this;
		}
		
		@RosettaAttribute("multiplier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("multiplier")
		@Override
		public CashflowFixing.CashflowFixingBuilder setMultiplier(BigDecimal _multiplier) {
			this.multiplier = _multiplier == null ? null : _multiplier;
			return this;
		}
		
		@RosettaAttribute("spread")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("spread")
		@Override
		public CashflowFixing.CashflowFixingBuilder setSpread(BigDecimal _spread) {
			this.spread = _spread == null ? null : _spread;
			return this;
		}
		
		@RosettaAttribute("capValue")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("capValue")
		@Override
		public CashflowFixing.CashflowFixingBuilder addCapValue(Strike _capValue) {
			if (_capValue != null) {
				this.capValue.add(_capValue.toBuilder());
			}
			return this;
		}
		
		@Override
		public CashflowFixing.CashflowFixingBuilder addCapValue(Strike _capValue, int idx) {
			getIndex(this.capValue, idx, () -> _capValue.toBuilder());
			return this;
		}
		
		@Override
		public CashflowFixing.CashflowFixingBuilder addCapValue(List<? extends Strike> capValues) {
			if (capValues != null) {
				for (final Strike toAdd : capValues) {
					this.capValue.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("capValue")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("capValue")
		@Override
		public CashflowFixing.CashflowFixingBuilder setCapValue(List<? extends Strike> capValues) {
			if (capValues == null) {
				this.capValue = new ArrayList<>();
			} else {
				this.capValue = capValues.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("floorValue")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("floorValue")
		@Override
		public CashflowFixing.CashflowFixingBuilder addFloorValue(Strike _floorValue) {
			if (_floorValue != null) {
				this.floorValue.add(_floorValue.toBuilder());
			}
			return this;
		}
		
		@Override
		public CashflowFixing.CashflowFixingBuilder addFloorValue(Strike _floorValue, int idx) {
			getIndex(this.floorValue, idx, () -> _floorValue.toBuilder());
			return this;
		}
		
		@Override
		public CashflowFixing.CashflowFixingBuilder addFloorValue(List<? extends Strike> floorValues) {
			if (floorValues != null) {
				for (final Strike toAdd : floorValues) {
					this.floorValue.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("floorValue")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("floorValue")
		@Override
		public CashflowFixing.CashflowFixingBuilder setFloorValue(List<? extends Strike> floorValues) {
			if (floorValues == null) {
				this.floorValue = new ArrayList<>();
			} else {
				this.floorValue = floorValues.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("negativeInterestRate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("negativeInterestRate")
		@Override
		public CashflowFixing.CashflowFixingBuilder setNegativeInterestRate(Boolean _negativeInterestRate) {
			this.negativeInterestRate = _negativeInterestRate == null ? null : _negativeInterestRate;
			return this;
		}
		
		@RosettaAttribute("rounding")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("rounding")
		@Override
		public CashflowFixing.CashflowFixingBuilder setRounding(Rounding _rounding) {
			this.rounding = _rounding == null ? null : _rounding.toBuilder();
			return this;
		}
		
		@Override
		public CashflowFixing build() {
			return new CashflowFixing.CashflowFixingImpl(this);
		}
		
		@Override
		public CashflowFixing.CashflowFixingBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CashflowFixing.CashflowFixingBuilder prune() {
			observationReference = observationReference.stream().filter(b->b!=null).<CashflowObservationReference.CashflowObservationReferenceBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			capValue = capValue.stream().filter(b->b!=null).<Strike.StrikeBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			floorValue = floorValue.stream().filter(b->b!=null).<Strike.StrikeBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (rounding!=null && !rounding.prune().hasData()) rounding = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getId()!=null) return true;
			if (getObservationReference()!=null && getObservationReference().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getCalculatedValue()!=null) return true;
			if (getMultiplier()!=null) return true;
			if (getSpread()!=null) return true;
			if (getCapValue()!=null && getCapValue().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getFloorValue()!=null && getFloorValue().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getNegativeInterestRate()!=null) return true;
			if (getRounding()!=null && getRounding().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CashflowFixing.CashflowFixingBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CashflowFixing.CashflowFixingBuilder o = (CashflowFixing.CashflowFixingBuilder) other;
			
			merger.mergeRosetta(getObservationReference(), o.getObservationReference(), this::getOrCreateObservationReference);
			merger.mergeRosetta(getCapValue(), o.getCapValue(), this::getOrCreateCapValue);
			merger.mergeRosetta(getFloorValue(), o.getFloorValue(), this::getOrCreateFloorValue);
			merger.mergeRosetta(getRounding(), o.getRounding(), this::setRounding);
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			merger.mergeBasic(getCalculatedValue(), o.getCalculatedValue(), this::setCalculatedValue);
			merger.mergeBasic(getMultiplier(), o.getMultiplier(), this::setMultiplier);
			merger.mergeBasic(getSpread(), o.getSpread(), this::setSpread);
			merger.mergeBasic(getNegativeInterestRate(), o.getNegativeInterestRate(), this::setNegativeInterestRate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CashflowFixing _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!ListEquals.listEquals(observationReference, _that.getObservationReference())) return false;
			if (!Objects.equals(calculatedValue, _that.getCalculatedValue())) return false;
			if (!Objects.equals(multiplier, _that.getMultiplier())) return false;
			if (!Objects.equals(spread, _that.getSpread())) return false;
			if (!ListEquals.listEquals(capValue, _that.getCapValue())) return false;
			if (!ListEquals.listEquals(floorValue, _that.getFloorValue())) return false;
			if (!Objects.equals(negativeInterestRate, _that.getNegativeInterestRate())) return false;
			if (!Objects.equals(rounding, _that.getRounding())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (observationReference != null ? observationReference.hashCode() : 0);
			_result = 31 * _result + (calculatedValue != null ? calculatedValue.hashCode() : 0);
			_result = 31 * _result + (multiplier != null ? multiplier.hashCode() : 0);
			_result = 31 * _result + (spread != null ? spread.hashCode() : 0);
			_result = 31 * _result + (capValue != null ? capValue.hashCode() : 0);
			_result = 31 * _result + (floorValue != null ? floorValue.hashCode() : 0);
			_result = 31 * _result + (negativeInterestRate != null ? negativeInterestRate.hashCode() : 0);
			_result = 31 * _result + (rounding != null ? rounding.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CashflowFixingBuilder {" +
				"id=" + this.id + ", " +
				"observationReference=" + this.observationReference + ", " +
				"calculatedValue=" + this.calculatedValue + ", " +
				"multiplier=" + this.multiplier + ", " +
				"spread=" + this.spread + ", " +
				"capValue=" + this.capValue + ", " +
				"floorValue=" + this.floorValue + ", " +
				"negativeInterestRate=" + this.negativeInterestRate + ", " +
				"rounding=" + this.rounding +
			'}';
		}
	}
}
