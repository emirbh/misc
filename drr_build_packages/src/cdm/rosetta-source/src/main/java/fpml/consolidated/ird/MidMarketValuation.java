package fpml.consolidated.ird;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import fpml.consolidated.ird.meta.MidMarketValuationMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision This type is a wrapper holding several different mid-market valuation methods described in the 2021 ISDA Definitions.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision This type is a wrapper holding several different mid-market valuation methods described in the 2021 ISDA Definitions.
 *
 */
@RosettaDataType(value="MidMarketValuation", builder=MidMarketValuation.MidMarketValuationBuilderImpl.class, version="2.1.1")
@RuneDataType(value="MidMarketValuation", model="fpml", builder=MidMarketValuation.MidMarketValuationBuilderImpl.class, version="2.1.1")
public interface MidMarketValuation extends RosettaModelObject {

	MidMarketValuationMeta metaData = new MidMarketValuationMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision An ISDA defined cash settlement method used for the determination of the applicable cash settlement amount. The method is defined in the 2021 ISDA Definitions, Section 18.2.1.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision An ISDA defined cash settlement method used for the determination of the applicable cash settlement amount. The method is defined in the 2021 ISDA Definitions, Section 18.2.1.
	 *
	 */
	MidMarketValuationMethod getIndicativeQuotations();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision An ISDA defined cash settlement method used for the determination of the applicable cash settlement amount. The method is defined in the 2021 ISDA Definitions, Section 18.2.2.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision An ISDA defined cash settlement method used for the determination of the applicable cash settlement amount. The method is defined in the 2021 ISDA Definitions, Section 18.2.2.
	 *
	 */
	MidMarketValuationMethod getIndicativeQuotationsAlternate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision An ISDA defined cash settlement method used for the determination of the applicable cash settlement amount. The method is defined in the 2021 ISDA Definitions, Section 18.2.3.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision An ISDA defined cash settlement method used for the determination of the applicable cash settlement amount. The method is defined in the 2021 ISDA Definitions, Section 18.2.3.
	 *
	 */
	MidMarketValuationMethod getCalculationAgentDetermination();

	/*********************** Build Methods  ***********************/
	MidMarketValuation build();
	
	MidMarketValuation.MidMarketValuationBuilder toBuilder();
	
	static MidMarketValuation.MidMarketValuationBuilder builder() {
		return new MidMarketValuation.MidMarketValuationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends MidMarketValuation> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends MidMarketValuation> getType() {
		return MidMarketValuation.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("indicativeQuotations"), processor, MidMarketValuationMethod.class, getIndicativeQuotations());
		processRosetta(path.newSubPath("indicativeQuotationsAlternate"), processor, MidMarketValuationMethod.class, getIndicativeQuotationsAlternate());
		processRosetta(path.newSubPath("calculationAgentDetermination"), processor, MidMarketValuationMethod.class, getCalculationAgentDetermination());
	}
	

	/*********************** Builder Interface  ***********************/
	interface MidMarketValuationBuilder extends MidMarketValuation, RosettaModelObjectBuilder {
		MidMarketValuationMethod.MidMarketValuationMethodBuilder getOrCreateIndicativeQuotations();
		@Override
		MidMarketValuationMethod.MidMarketValuationMethodBuilder getIndicativeQuotations();
		MidMarketValuationMethod.MidMarketValuationMethodBuilder getOrCreateIndicativeQuotationsAlternate();
		@Override
		MidMarketValuationMethod.MidMarketValuationMethodBuilder getIndicativeQuotationsAlternate();
		MidMarketValuationMethod.MidMarketValuationMethodBuilder getOrCreateCalculationAgentDetermination();
		@Override
		MidMarketValuationMethod.MidMarketValuationMethodBuilder getCalculationAgentDetermination();
		MidMarketValuation.MidMarketValuationBuilder setIndicativeQuotations(MidMarketValuationMethod indicativeQuotations);
		MidMarketValuation.MidMarketValuationBuilder setIndicativeQuotationsAlternate(MidMarketValuationMethod indicativeQuotationsAlternate);
		MidMarketValuation.MidMarketValuationBuilder setCalculationAgentDetermination(MidMarketValuationMethod calculationAgentDetermination);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("indicativeQuotations"), processor, MidMarketValuationMethod.MidMarketValuationMethodBuilder.class, getIndicativeQuotations());
			processRosetta(path.newSubPath("indicativeQuotationsAlternate"), processor, MidMarketValuationMethod.MidMarketValuationMethodBuilder.class, getIndicativeQuotationsAlternate());
			processRosetta(path.newSubPath("calculationAgentDetermination"), processor, MidMarketValuationMethod.MidMarketValuationMethodBuilder.class, getCalculationAgentDetermination());
		}
		

		MidMarketValuation.MidMarketValuationBuilder prune();
	}

	/*********************** Immutable Implementation of MidMarketValuation  ***********************/
	class MidMarketValuationImpl implements MidMarketValuation {
		private final MidMarketValuationMethod indicativeQuotations;
		private final MidMarketValuationMethod indicativeQuotationsAlternate;
		private final MidMarketValuationMethod calculationAgentDetermination;
		
		protected MidMarketValuationImpl(MidMarketValuation.MidMarketValuationBuilder builder) {
			this.indicativeQuotations = ofNullable(builder.getIndicativeQuotations()).map(f->f.build()).orElse(null);
			this.indicativeQuotationsAlternate = ofNullable(builder.getIndicativeQuotationsAlternate()).map(f->f.build()).orElse(null);
			this.calculationAgentDetermination = ofNullable(builder.getCalculationAgentDetermination()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("indicativeQuotations")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("indicativeQuotations")
		public MidMarketValuationMethod getIndicativeQuotations() {
			return indicativeQuotations;
		}
		
		@Override
		@RosettaAttribute("indicativeQuotationsAlternate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("indicativeQuotationsAlternate")
		public MidMarketValuationMethod getIndicativeQuotationsAlternate() {
			return indicativeQuotationsAlternate;
		}
		
		@Override
		@RosettaAttribute("calculationAgentDetermination")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("calculationAgentDetermination")
		public MidMarketValuationMethod getCalculationAgentDetermination() {
			return calculationAgentDetermination;
		}
		
		@Override
		public MidMarketValuation build() {
			return this;
		}
		
		@Override
		public MidMarketValuation.MidMarketValuationBuilder toBuilder() {
			MidMarketValuation.MidMarketValuationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(MidMarketValuation.MidMarketValuationBuilder builder) {
			ofNullable(getIndicativeQuotations()).ifPresent(builder::setIndicativeQuotations);
			ofNullable(getIndicativeQuotationsAlternate()).ifPresent(builder::setIndicativeQuotationsAlternate);
			ofNullable(getCalculationAgentDetermination()).ifPresent(builder::setCalculationAgentDetermination);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MidMarketValuation _that = getType().cast(o);
		
			if (!Objects.equals(indicativeQuotations, _that.getIndicativeQuotations())) return false;
			if (!Objects.equals(indicativeQuotationsAlternate, _that.getIndicativeQuotationsAlternate())) return false;
			if (!Objects.equals(calculationAgentDetermination, _that.getCalculationAgentDetermination())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (indicativeQuotations != null ? indicativeQuotations.hashCode() : 0);
			_result = 31 * _result + (indicativeQuotationsAlternate != null ? indicativeQuotationsAlternate.hashCode() : 0);
			_result = 31 * _result + (calculationAgentDetermination != null ? calculationAgentDetermination.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MidMarketValuation {" +
				"indicativeQuotations=" + this.indicativeQuotations + ", " +
				"indicativeQuotationsAlternate=" + this.indicativeQuotationsAlternate + ", " +
				"calculationAgentDetermination=" + this.calculationAgentDetermination +
			'}';
		}
	}

	/*********************** Builder Implementation of MidMarketValuation  ***********************/
	class MidMarketValuationBuilderImpl implements MidMarketValuation.MidMarketValuationBuilder {
	
		protected MidMarketValuationMethod.MidMarketValuationMethodBuilder indicativeQuotations;
		protected MidMarketValuationMethod.MidMarketValuationMethodBuilder indicativeQuotationsAlternate;
		protected MidMarketValuationMethod.MidMarketValuationMethodBuilder calculationAgentDetermination;
		
		@Override
		@RosettaAttribute("indicativeQuotations")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("indicativeQuotations")
		public MidMarketValuationMethod.MidMarketValuationMethodBuilder getIndicativeQuotations() {
			return indicativeQuotations;
		}
		
		@Override
		public MidMarketValuationMethod.MidMarketValuationMethodBuilder getOrCreateIndicativeQuotations() {
			MidMarketValuationMethod.MidMarketValuationMethodBuilder result;
			if (indicativeQuotations!=null) {
				result = indicativeQuotations;
			}
			else {
				result = indicativeQuotations = MidMarketValuationMethod.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("indicativeQuotationsAlternate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("indicativeQuotationsAlternate")
		public MidMarketValuationMethod.MidMarketValuationMethodBuilder getIndicativeQuotationsAlternate() {
			return indicativeQuotationsAlternate;
		}
		
		@Override
		public MidMarketValuationMethod.MidMarketValuationMethodBuilder getOrCreateIndicativeQuotationsAlternate() {
			MidMarketValuationMethod.MidMarketValuationMethodBuilder result;
			if (indicativeQuotationsAlternate!=null) {
				result = indicativeQuotationsAlternate;
			}
			else {
				result = indicativeQuotationsAlternate = MidMarketValuationMethod.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("calculationAgentDetermination")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("calculationAgentDetermination")
		public MidMarketValuationMethod.MidMarketValuationMethodBuilder getCalculationAgentDetermination() {
			return calculationAgentDetermination;
		}
		
		@Override
		public MidMarketValuationMethod.MidMarketValuationMethodBuilder getOrCreateCalculationAgentDetermination() {
			MidMarketValuationMethod.MidMarketValuationMethodBuilder result;
			if (calculationAgentDetermination!=null) {
				result = calculationAgentDetermination;
			}
			else {
				result = calculationAgentDetermination = MidMarketValuationMethod.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("indicativeQuotations")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("indicativeQuotations")
		@Override
		public MidMarketValuation.MidMarketValuationBuilder setIndicativeQuotations(MidMarketValuationMethod _indicativeQuotations) {
			this.indicativeQuotations = _indicativeQuotations == null ? null : _indicativeQuotations.toBuilder();
			return this;
		}
		
		@RosettaAttribute("indicativeQuotationsAlternate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("indicativeQuotationsAlternate")
		@Override
		public MidMarketValuation.MidMarketValuationBuilder setIndicativeQuotationsAlternate(MidMarketValuationMethod _indicativeQuotationsAlternate) {
			this.indicativeQuotationsAlternate = _indicativeQuotationsAlternate == null ? null : _indicativeQuotationsAlternate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("calculationAgentDetermination")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("calculationAgentDetermination")
		@Override
		public MidMarketValuation.MidMarketValuationBuilder setCalculationAgentDetermination(MidMarketValuationMethod _calculationAgentDetermination) {
			this.calculationAgentDetermination = _calculationAgentDetermination == null ? null : _calculationAgentDetermination.toBuilder();
			return this;
		}
		
		@Override
		public MidMarketValuation build() {
			return new MidMarketValuation.MidMarketValuationImpl(this);
		}
		
		@Override
		public MidMarketValuation.MidMarketValuationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MidMarketValuation.MidMarketValuationBuilder prune() {
			if (indicativeQuotations!=null && !indicativeQuotations.prune().hasData()) indicativeQuotations = null;
			if (indicativeQuotationsAlternate!=null && !indicativeQuotationsAlternate.prune().hasData()) indicativeQuotationsAlternate = null;
			if (calculationAgentDetermination!=null && !calculationAgentDetermination.prune().hasData()) calculationAgentDetermination = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getIndicativeQuotations()!=null && getIndicativeQuotations().hasData()) return true;
			if (getIndicativeQuotationsAlternate()!=null && getIndicativeQuotationsAlternate().hasData()) return true;
			if (getCalculationAgentDetermination()!=null && getCalculationAgentDetermination().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MidMarketValuation.MidMarketValuationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			MidMarketValuation.MidMarketValuationBuilder o = (MidMarketValuation.MidMarketValuationBuilder) other;
			
			merger.mergeRosetta(getIndicativeQuotations(), o.getIndicativeQuotations(), this::setIndicativeQuotations);
			merger.mergeRosetta(getIndicativeQuotationsAlternate(), o.getIndicativeQuotationsAlternate(), this::setIndicativeQuotationsAlternate);
			merger.mergeRosetta(getCalculationAgentDetermination(), o.getCalculationAgentDetermination(), this::setCalculationAgentDetermination);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MidMarketValuation _that = getType().cast(o);
		
			if (!Objects.equals(indicativeQuotations, _that.getIndicativeQuotations())) return false;
			if (!Objects.equals(indicativeQuotationsAlternate, _that.getIndicativeQuotationsAlternate())) return false;
			if (!Objects.equals(calculationAgentDetermination, _that.getCalculationAgentDetermination())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (indicativeQuotations != null ? indicativeQuotations.hashCode() : 0);
			_result = 31 * _result + (indicativeQuotationsAlternate != null ? indicativeQuotationsAlternate.hashCode() : 0);
			_result = 31 * _result + (calculationAgentDetermination != null ? calculationAgentDetermination.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MidMarketValuationBuilder {" +
				"indicativeQuotations=" + this.indicativeQuotations + ", " +
				"indicativeQuotationsAlternate=" + this.indicativeQuotationsAlternate + ", " +
				"calculationAgentDetermination=" + this.calculationAgentDetermination +
			'}';
		}
	}
}
