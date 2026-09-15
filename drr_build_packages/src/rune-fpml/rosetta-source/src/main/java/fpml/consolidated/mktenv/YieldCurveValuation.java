package fpml.consolidated.mktenv;

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
import fpml.consolidated.asset.AnyAssetReference;
import fpml.consolidated.mktenv.meta.YieldCurveValuationMeta;
import fpml.consolidated.riskdef.PricingStructureValuation;
import fpml.consolidated.riskdef.QuotedAssetSet;
import fpml.consolidated.riskdef.ValuationScenarioReference;
import fpml.consolidated.shared.IdentifiedDate;
import java.time.ZonedDateTime;
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
 * Provision The values of a yield curve, including possibly inputs and outputs (dfs, forwards, zero rates).
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision The values of a yield curve, including possibly inputs and outputs (dfs, forwards, zero rates).
 *
 */
@RosettaDataType(value="YieldCurveValuation", builder=YieldCurveValuation.YieldCurveValuationBuilderImpl.class, version="2.1.1")
@RuneDataType(value="YieldCurveValuation", model="fpml", builder=YieldCurveValuation.YieldCurveValuationBuilderImpl.class, version="2.1.1")
public interface YieldCurveValuation extends PricingStructureValuation {

	YieldCurveValuationMeta metaData = new YieldCurveValuationMeta();

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
	QuotedAssetSet getInputs();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A curve of zero rates.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A curve of zero rates.
	 *
	 */
	ZeroRateCurve getZeroCurve();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A curve of forward rates.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A curve of forward rates.
	 *
	 */
	List<? extends ForwardRateCurve> getForwardCurve();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A curve of discount factors.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A curve of discount factors.
	 *
	 */
	TermCurve getDiscountFactorCurve();

	/*********************** Build Methods  ***********************/
	YieldCurveValuation build();
	
	YieldCurveValuation.YieldCurveValuationBuilder toBuilder();
	
	static YieldCurveValuation.YieldCurveValuationBuilder builder() {
		return new YieldCurveValuation.YieldCurveValuationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends YieldCurveValuation> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends YieldCurveValuation> getType() {
		return YieldCurveValuation.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processor.processBasic(path.newSubPath("definitionRef"), String.class, getDefinitionRef(), this);
		processRosetta(path.newSubPath("objectReference"), processor, AnyAssetReference.class, getObjectReference());
		processRosetta(path.newSubPath("valuationScenarioReference"), processor, ValuationScenarioReference.class, getValuationScenarioReference());
		processRosetta(path.newSubPath("baseDate"), processor, IdentifiedDate.class, getBaseDate());
		processRosetta(path.newSubPath("spotDate"), processor, IdentifiedDate.class, getSpotDate());
		processRosetta(path.newSubPath("inputDataDate"), processor, IdentifiedDate.class, getInputDataDate());
		processRosetta(path.newSubPath("endDate"), processor, IdentifiedDate.class, getEndDate());
		processor.processBasic(path.newSubPath("buildDateTime"), ZonedDateTime.class, getBuildDateTime(), this);
		processRosetta(path.newSubPath("inputs"), processor, QuotedAssetSet.class, getInputs());
		processRosetta(path.newSubPath("zeroCurve"), processor, ZeroRateCurve.class, getZeroCurve());
		processRosetta(path.newSubPath("forwardCurve"), processor, ForwardRateCurve.class, getForwardCurve());
		processRosetta(path.newSubPath("discountFactorCurve"), processor, TermCurve.class, getDiscountFactorCurve());
	}
	

	/*********************** Builder Interface  ***********************/
	interface YieldCurveValuationBuilder extends YieldCurveValuation, PricingStructureValuation.PricingStructureValuationBuilder {
		QuotedAssetSet.QuotedAssetSetBuilder getOrCreateInputs();
		@Override
		QuotedAssetSet.QuotedAssetSetBuilder getInputs();
		ZeroRateCurve.ZeroRateCurveBuilder getOrCreateZeroCurve();
		@Override
		ZeroRateCurve.ZeroRateCurveBuilder getZeroCurve();
		ForwardRateCurve.ForwardRateCurveBuilder getOrCreateForwardCurve(int index);
		@Override
		List<? extends ForwardRateCurve.ForwardRateCurveBuilder> getForwardCurve();
		TermCurve.TermCurveBuilder getOrCreateDiscountFactorCurve();
		@Override
		TermCurve.TermCurveBuilder getDiscountFactorCurve();
		@Override
		YieldCurveValuation.YieldCurveValuationBuilder setId(String id);
		@Override
		YieldCurveValuation.YieldCurveValuationBuilder setDefinitionRef(String definitionRef);
		@Override
		YieldCurveValuation.YieldCurveValuationBuilder setObjectReference(AnyAssetReference objectReference);
		@Override
		YieldCurveValuation.YieldCurveValuationBuilder setValuationScenarioReference(ValuationScenarioReference valuationScenarioReference);
		@Override
		YieldCurveValuation.YieldCurveValuationBuilder setBaseDate(IdentifiedDate baseDate);
		@Override
		YieldCurveValuation.YieldCurveValuationBuilder setSpotDate(IdentifiedDate spotDate);
		@Override
		YieldCurveValuation.YieldCurveValuationBuilder setInputDataDate(IdentifiedDate inputDataDate);
		@Override
		YieldCurveValuation.YieldCurveValuationBuilder setEndDate(IdentifiedDate endDate);
		@Override
		YieldCurveValuation.YieldCurveValuationBuilder setBuildDateTime(ZonedDateTime buildDateTime);
		YieldCurveValuation.YieldCurveValuationBuilder setInputs(QuotedAssetSet inputs);
		YieldCurveValuation.YieldCurveValuationBuilder setZeroCurve(ZeroRateCurve zeroCurve);
		YieldCurveValuation.YieldCurveValuationBuilder addForwardCurve(ForwardRateCurve forwardCurve);
		YieldCurveValuation.YieldCurveValuationBuilder addForwardCurve(ForwardRateCurve forwardCurve, int idx);
		YieldCurveValuation.YieldCurveValuationBuilder addForwardCurve(List<? extends ForwardRateCurve> forwardCurve);
		YieldCurveValuation.YieldCurveValuationBuilder setForwardCurve(List<? extends ForwardRateCurve> forwardCurve);
		YieldCurveValuation.YieldCurveValuationBuilder setDiscountFactorCurve(TermCurve discountFactorCurve);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processor.processBasic(path.newSubPath("definitionRef"), String.class, getDefinitionRef(), this);
			processRosetta(path.newSubPath("objectReference"), processor, AnyAssetReference.AnyAssetReferenceBuilder.class, getObjectReference());
			processRosetta(path.newSubPath("valuationScenarioReference"), processor, ValuationScenarioReference.ValuationScenarioReferenceBuilder.class, getValuationScenarioReference());
			processRosetta(path.newSubPath("baseDate"), processor, IdentifiedDate.IdentifiedDateBuilder.class, getBaseDate());
			processRosetta(path.newSubPath("spotDate"), processor, IdentifiedDate.IdentifiedDateBuilder.class, getSpotDate());
			processRosetta(path.newSubPath("inputDataDate"), processor, IdentifiedDate.IdentifiedDateBuilder.class, getInputDataDate());
			processRosetta(path.newSubPath("endDate"), processor, IdentifiedDate.IdentifiedDateBuilder.class, getEndDate());
			processor.processBasic(path.newSubPath("buildDateTime"), ZonedDateTime.class, getBuildDateTime(), this);
			processRosetta(path.newSubPath("inputs"), processor, QuotedAssetSet.QuotedAssetSetBuilder.class, getInputs());
			processRosetta(path.newSubPath("zeroCurve"), processor, ZeroRateCurve.ZeroRateCurveBuilder.class, getZeroCurve());
			processRosetta(path.newSubPath("forwardCurve"), processor, ForwardRateCurve.ForwardRateCurveBuilder.class, getForwardCurve());
			processRosetta(path.newSubPath("discountFactorCurve"), processor, TermCurve.TermCurveBuilder.class, getDiscountFactorCurve());
		}
		

		YieldCurveValuation.YieldCurveValuationBuilder prune();
	}

	/*********************** Immutable Implementation of YieldCurveValuation  ***********************/
	class YieldCurveValuationImpl extends PricingStructureValuation.PricingStructureValuationImpl implements YieldCurveValuation {
		private final QuotedAssetSet inputs;
		private final ZeroRateCurve zeroCurve;
		private final List<? extends ForwardRateCurve> forwardCurve;
		private final TermCurve discountFactorCurve;
		
		protected YieldCurveValuationImpl(YieldCurveValuation.YieldCurveValuationBuilder builder) {
			super(builder);
			this.inputs = ofNullable(builder.getInputs()).map(f->f.build()).orElse(null);
			this.zeroCurve = ofNullable(builder.getZeroCurve()).map(f->f.build()).orElse(null);
			this.forwardCurve = ofNullable(builder.getForwardCurve()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.discountFactorCurve = ofNullable(builder.getDiscountFactorCurve()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("inputs")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("inputs")
		public QuotedAssetSet getInputs() {
			return inputs;
		}
		
		@Override
		@RosettaAttribute("zeroCurve")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("zeroCurve")
		public ZeroRateCurve getZeroCurve() {
			return zeroCurve;
		}
		
		@Override
		@RosettaAttribute("forwardCurve")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("forwardCurve")
		public List<? extends ForwardRateCurve> getForwardCurve() {
			return forwardCurve;
		}
		
		@Override
		@RosettaAttribute("discountFactorCurve")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("discountFactorCurve")
		public TermCurve getDiscountFactorCurve() {
			return discountFactorCurve;
		}
		
		@Override
		public YieldCurveValuation build() {
			return this;
		}
		
		@Override
		public YieldCurveValuation.YieldCurveValuationBuilder toBuilder() {
			YieldCurveValuation.YieldCurveValuationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(YieldCurveValuation.YieldCurveValuationBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getInputs()).ifPresent(builder::setInputs);
			ofNullable(getZeroCurve()).ifPresent(builder::setZeroCurve);
			ofNullable(getForwardCurve()).ifPresent(builder::setForwardCurve);
			ofNullable(getDiscountFactorCurve()).ifPresent(builder::setDiscountFactorCurve);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			YieldCurveValuation _that = getType().cast(o);
		
			if (!Objects.equals(inputs, _that.getInputs())) return false;
			if (!Objects.equals(zeroCurve, _that.getZeroCurve())) return false;
			if (!ListEquals.listEquals(forwardCurve, _that.getForwardCurve())) return false;
			if (!Objects.equals(discountFactorCurve, _that.getDiscountFactorCurve())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (inputs != null ? inputs.hashCode() : 0);
			_result = 31 * _result + (zeroCurve != null ? zeroCurve.hashCode() : 0);
			_result = 31 * _result + (forwardCurve != null ? forwardCurve.hashCode() : 0);
			_result = 31 * _result + (discountFactorCurve != null ? discountFactorCurve.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "YieldCurveValuation {" +
				"inputs=" + this.inputs + ", " +
				"zeroCurve=" + this.zeroCurve + ", " +
				"forwardCurve=" + this.forwardCurve + ", " +
				"discountFactorCurve=" + this.discountFactorCurve +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of YieldCurveValuation  ***********************/
	class YieldCurveValuationBuilderImpl extends PricingStructureValuation.PricingStructureValuationBuilderImpl implements YieldCurveValuation.YieldCurveValuationBuilder {
	
		protected QuotedAssetSet.QuotedAssetSetBuilder inputs;
		protected ZeroRateCurve.ZeroRateCurveBuilder zeroCurve;
		protected List<ForwardRateCurve.ForwardRateCurveBuilder> forwardCurve = new ArrayList<>();
		protected TermCurve.TermCurveBuilder discountFactorCurve;
		
		@Override
		@RosettaAttribute("inputs")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("inputs")
		public QuotedAssetSet.QuotedAssetSetBuilder getInputs() {
			return inputs;
		}
		
		@Override
		public QuotedAssetSet.QuotedAssetSetBuilder getOrCreateInputs() {
			QuotedAssetSet.QuotedAssetSetBuilder result;
			if (inputs!=null) {
				result = inputs;
			}
			else {
				result = inputs = QuotedAssetSet.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("zeroCurve")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("zeroCurve")
		public ZeroRateCurve.ZeroRateCurveBuilder getZeroCurve() {
			return zeroCurve;
		}
		
		@Override
		public ZeroRateCurve.ZeroRateCurveBuilder getOrCreateZeroCurve() {
			ZeroRateCurve.ZeroRateCurveBuilder result;
			if (zeroCurve!=null) {
				result = zeroCurve;
			}
			else {
				result = zeroCurve = ZeroRateCurve.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("forwardCurve")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("forwardCurve")
		public List<? extends ForwardRateCurve.ForwardRateCurveBuilder> getForwardCurve() {
			return forwardCurve;
		}
		
		@Override
		public ForwardRateCurve.ForwardRateCurveBuilder getOrCreateForwardCurve(int index) {
			if (forwardCurve==null) {
				this.forwardCurve = new ArrayList<>();
			}
			return getIndex(forwardCurve, index, () -> {
						ForwardRateCurve.ForwardRateCurveBuilder newForwardCurve = ForwardRateCurve.builder();
						return newForwardCurve;
					});
		}
		
		@Override
		@RosettaAttribute("discountFactorCurve")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("discountFactorCurve")
		public TermCurve.TermCurveBuilder getDiscountFactorCurve() {
			return discountFactorCurve;
		}
		
		@Override
		public TermCurve.TermCurveBuilder getOrCreateDiscountFactorCurve() {
			TermCurve.TermCurveBuilder result;
			if (discountFactorCurve!=null) {
				result = discountFactorCurve;
			}
			else {
				result = discountFactorCurve = TermCurve.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public YieldCurveValuation.YieldCurveValuationBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("definitionRef")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("definitionRef")
		@Override
		public YieldCurveValuation.YieldCurveValuationBuilder setDefinitionRef(String _definitionRef) {
			this.definitionRef = _definitionRef == null ? null : _definitionRef;
			return this;
		}
		
		@RosettaAttribute("objectReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("objectReference")
		@Override
		public YieldCurveValuation.YieldCurveValuationBuilder setObjectReference(AnyAssetReference _objectReference) {
			this.objectReference = _objectReference == null ? null : _objectReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("valuationScenarioReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("valuationScenarioReference")
		@Override
		public YieldCurveValuation.YieldCurveValuationBuilder setValuationScenarioReference(ValuationScenarioReference _valuationScenarioReference) {
			this.valuationScenarioReference = _valuationScenarioReference == null ? null : _valuationScenarioReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("baseDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("baseDate")
		@Override
		public YieldCurveValuation.YieldCurveValuationBuilder setBaseDate(IdentifiedDate _baseDate) {
			this.baseDate = _baseDate == null ? null : _baseDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("spotDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("spotDate")
		@Override
		public YieldCurveValuation.YieldCurveValuationBuilder setSpotDate(IdentifiedDate _spotDate) {
			this.spotDate = _spotDate == null ? null : _spotDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("inputDataDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("inputDataDate")
		@Override
		public YieldCurveValuation.YieldCurveValuationBuilder setInputDataDate(IdentifiedDate _inputDataDate) {
			this.inputDataDate = _inputDataDate == null ? null : _inputDataDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("endDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("endDate")
		@Override
		public YieldCurveValuation.YieldCurveValuationBuilder setEndDate(IdentifiedDate _endDate) {
			this.endDate = _endDate == null ? null : _endDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("buildDateTime")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("buildDateTime")
		@Override
		public YieldCurveValuation.YieldCurveValuationBuilder setBuildDateTime(ZonedDateTime _buildDateTime) {
			this.buildDateTime = _buildDateTime == null ? null : _buildDateTime;
			return this;
		}
		
		@RosettaAttribute("inputs")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("inputs")
		@Override
		public YieldCurveValuation.YieldCurveValuationBuilder setInputs(QuotedAssetSet _inputs) {
			this.inputs = _inputs == null ? null : _inputs.toBuilder();
			return this;
		}
		
		@RosettaAttribute("zeroCurve")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("zeroCurve")
		@Override
		public YieldCurveValuation.YieldCurveValuationBuilder setZeroCurve(ZeroRateCurve _zeroCurve) {
			this.zeroCurve = _zeroCurve == null ? null : _zeroCurve.toBuilder();
			return this;
		}
		
		@RosettaAttribute("forwardCurve")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("forwardCurve")
		@Override
		public YieldCurveValuation.YieldCurveValuationBuilder addForwardCurve(ForwardRateCurve _forwardCurve) {
			if (_forwardCurve != null) {
				this.forwardCurve.add(_forwardCurve.toBuilder());
			}
			return this;
		}
		
		@Override
		public YieldCurveValuation.YieldCurveValuationBuilder addForwardCurve(ForwardRateCurve _forwardCurve, int idx) {
			getIndex(this.forwardCurve, idx, () -> _forwardCurve.toBuilder());
			return this;
		}
		
		@Override
		public YieldCurveValuation.YieldCurveValuationBuilder addForwardCurve(List<? extends ForwardRateCurve> forwardCurves) {
			if (forwardCurves != null) {
				for (final ForwardRateCurve toAdd : forwardCurves) {
					this.forwardCurve.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("forwardCurve")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("forwardCurve")
		@Override
		public YieldCurveValuation.YieldCurveValuationBuilder setForwardCurve(List<? extends ForwardRateCurve> forwardCurves) {
			if (forwardCurves == null) {
				this.forwardCurve = new ArrayList<>();
			} else {
				this.forwardCurve = forwardCurves.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("discountFactorCurve")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("discountFactorCurve")
		@Override
		public YieldCurveValuation.YieldCurveValuationBuilder setDiscountFactorCurve(TermCurve _discountFactorCurve) {
			this.discountFactorCurve = _discountFactorCurve == null ? null : _discountFactorCurve.toBuilder();
			return this;
		}
		
		@Override
		public YieldCurveValuation build() {
			return new YieldCurveValuation.YieldCurveValuationImpl(this);
		}
		
		@Override
		public YieldCurveValuation.YieldCurveValuationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public YieldCurveValuation.YieldCurveValuationBuilder prune() {
			super.prune();
			if (inputs!=null && !inputs.prune().hasData()) inputs = null;
			if (zeroCurve!=null && !zeroCurve.prune().hasData()) zeroCurve = null;
			forwardCurve = forwardCurve.stream().filter(b->b!=null).<ForwardRateCurve.ForwardRateCurveBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (discountFactorCurve!=null && !discountFactorCurve.prune().hasData()) discountFactorCurve = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getInputs()!=null && getInputs().hasData()) return true;
			if (getZeroCurve()!=null && getZeroCurve().hasData()) return true;
			if (getForwardCurve()!=null && getForwardCurve().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getDiscountFactorCurve()!=null && getDiscountFactorCurve().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public YieldCurveValuation.YieldCurveValuationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			YieldCurveValuation.YieldCurveValuationBuilder o = (YieldCurveValuation.YieldCurveValuationBuilder) other;
			
			merger.mergeRosetta(getInputs(), o.getInputs(), this::setInputs);
			merger.mergeRosetta(getZeroCurve(), o.getZeroCurve(), this::setZeroCurve);
			merger.mergeRosetta(getForwardCurve(), o.getForwardCurve(), this::getOrCreateForwardCurve);
			merger.mergeRosetta(getDiscountFactorCurve(), o.getDiscountFactorCurve(), this::setDiscountFactorCurve);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			YieldCurveValuation _that = getType().cast(o);
		
			if (!Objects.equals(inputs, _that.getInputs())) return false;
			if (!Objects.equals(zeroCurve, _that.getZeroCurve())) return false;
			if (!ListEquals.listEquals(forwardCurve, _that.getForwardCurve())) return false;
			if (!Objects.equals(discountFactorCurve, _that.getDiscountFactorCurve())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (inputs != null ? inputs.hashCode() : 0);
			_result = 31 * _result + (zeroCurve != null ? zeroCurve.hashCode() : 0);
			_result = 31 * _result + (forwardCurve != null ? forwardCurve.hashCode() : 0);
			_result = 31 * _result + (discountFactorCurve != null ? discountFactorCurve.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "YieldCurveValuationBuilder {" +
				"inputs=" + this.inputs + ", " +
				"zeroCurve=" + this.zeroCurve + ", " +
				"forwardCurve=" + this.forwardCurve + ", " +
				"discountFactorCurve=" + this.discountFactorCurve +
			'}' + " " + super.toString();
		}
	}
}
