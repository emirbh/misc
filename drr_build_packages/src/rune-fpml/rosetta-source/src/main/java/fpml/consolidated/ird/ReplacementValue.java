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
import fpml.consolidated.ird.meta.ReplacementValueMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision This type is a wrapper holding several different replacement value cash settlement methods described in the 2021 ISDA Definitions.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision This type is a wrapper holding several different replacement value cash settlement methods described in the 2021 ISDA Definitions.
 *
 */
@RosettaDataType(value="ReplacementValue", builder=ReplacementValue.ReplacementValueBuilderImpl.class, version="2.1.1")
@RuneDataType(value="ReplacementValue", model="fpml", builder=ReplacementValue.ReplacementValueBuilderImpl.class, version="2.1.1")
public interface ReplacementValue extends RosettaModelObject {

	ReplacementValueMeta metaData = new ReplacementValueMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision An ISDA defined cash settlement method used for the determination of the applicable cash settlement amount. The method is defined in the 2021 ISDA Definitions, Section 18.2.4.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision An ISDA defined cash settlement method used for the determination of the applicable cash settlement amount. The method is defined in the 2021 ISDA Definitions, Section 18.2.4.
	 *
	 */
	ReplacementValueFirmQuotationsMethod getFirmQuotations();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision An ISDA defined cash settlement method used for the determination of the applicable cash settlement amount. The method is defined in the 2021 ISDA Definitions, Section 18.2.5.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision An ISDA defined cash settlement method used for the determination of the applicable cash settlement amount. The method is defined in the 2021 ISDA Definitions, Section 18.2.5.
	 *
	 */
	ReplacementValueCalculationAgentDeterminationMethod getCalculationAgentDetermination();

	/*********************** Build Methods  ***********************/
	ReplacementValue build();
	
	ReplacementValue.ReplacementValueBuilder toBuilder();
	
	static ReplacementValue.ReplacementValueBuilder builder() {
		return new ReplacementValue.ReplacementValueBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ReplacementValue> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ReplacementValue> getType() {
		return ReplacementValue.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("firmQuotations"), processor, ReplacementValueFirmQuotationsMethod.class, getFirmQuotations());
		processRosetta(path.newSubPath("calculationAgentDetermination"), processor, ReplacementValueCalculationAgentDeterminationMethod.class, getCalculationAgentDetermination());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ReplacementValueBuilder extends ReplacementValue, RosettaModelObjectBuilder {
		ReplacementValueFirmQuotationsMethod.ReplacementValueFirmQuotationsMethodBuilder getOrCreateFirmQuotations();
		@Override
		ReplacementValueFirmQuotationsMethod.ReplacementValueFirmQuotationsMethodBuilder getFirmQuotations();
		ReplacementValueCalculationAgentDeterminationMethod.ReplacementValueCalculationAgentDeterminationMethodBuilder getOrCreateCalculationAgentDetermination();
		@Override
		ReplacementValueCalculationAgentDeterminationMethod.ReplacementValueCalculationAgentDeterminationMethodBuilder getCalculationAgentDetermination();
		ReplacementValue.ReplacementValueBuilder setFirmQuotations(ReplacementValueFirmQuotationsMethod firmQuotations);
		ReplacementValue.ReplacementValueBuilder setCalculationAgentDetermination(ReplacementValueCalculationAgentDeterminationMethod calculationAgentDetermination);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("firmQuotations"), processor, ReplacementValueFirmQuotationsMethod.ReplacementValueFirmQuotationsMethodBuilder.class, getFirmQuotations());
			processRosetta(path.newSubPath("calculationAgentDetermination"), processor, ReplacementValueCalculationAgentDeterminationMethod.ReplacementValueCalculationAgentDeterminationMethodBuilder.class, getCalculationAgentDetermination());
		}
		

		ReplacementValue.ReplacementValueBuilder prune();
	}

	/*********************** Immutable Implementation of ReplacementValue  ***********************/
	class ReplacementValueImpl implements ReplacementValue {
		private final ReplacementValueFirmQuotationsMethod firmQuotations;
		private final ReplacementValueCalculationAgentDeterminationMethod calculationAgentDetermination;
		
		protected ReplacementValueImpl(ReplacementValue.ReplacementValueBuilder builder) {
			this.firmQuotations = ofNullable(builder.getFirmQuotations()).map(f->f.build()).orElse(null);
			this.calculationAgentDetermination = ofNullable(builder.getCalculationAgentDetermination()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("firmQuotations")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("firmQuotations")
		public ReplacementValueFirmQuotationsMethod getFirmQuotations() {
			return firmQuotations;
		}
		
		@Override
		@RosettaAttribute("calculationAgentDetermination")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("calculationAgentDetermination")
		public ReplacementValueCalculationAgentDeterminationMethod getCalculationAgentDetermination() {
			return calculationAgentDetermination;
		}
		
		@Override
		public ReplacementValue build() {
			return this;
		}
		
		@Override
		public ReplacementValue.ReplacementValueBuilder toBuilder() {
			ReplacementValue.ReplacementValueBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ReplacementValue.ReplacementValueBuilder builder) {
			ofNullable(getFirmQuotations()).ifPresent(builder::setFirmQuotations);
			ofNullable(getCalculationAgentDetermination()).ifPresent(builder::setCalculationAgentDetermination);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ReplacementValue _that = getType().cast(o);
		
			if (!Objects.equals(firmQuotations, _that.getFirmQuotations())) return false;
			if (!Objects.equals(calculationAgentDetermination, _that.getCalculationAgentDetermination())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (firmQuotations != null ? firmQuotations.hashCode() : 0);
			_result = 31 * _result + (calculationAgentDetermination != null ? calculationAgentDetermination.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReplacementValue {" +
				"firmQuotations=" + this.firmQuotations + ", " +
				"calculationAgentDetermination=" + this.calculationAgentDetermination +
			'}';
		}
	}

	/*********************** Builder Implementation of ReplacementValue  ***********************/
	class ReplacementValueBuilderImpl implements ReplacementValue.ReplacementValueBuilder {
	
		protected ReplacementValueFirmQuotationsMethod.ReplacementValueFirmQuotationsMethodBuilder firmQuotations;
		protected ReplacementValueCalculationAgentDeterminationMethod.ReplacementValueCalculationAgentDeterminationMethodBuilder calculationAgentDetermination;
		
		@Override
		@RosettaAttribute("firmQuotations")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("firmQuotations")
		public ReplacementValueFirmQuotationsMethod.ReplacementValueFirmQuotationsMethodBuilder getFirmQuotations() {
			return firmQuotations;
		}
		
		@Override
		public ReplacementValueFirmQuotationsMethod.ReplacementValueFirmQuotationsMethodBuilder getOrCreateFirmQuotations() {
			ReplacementValueFirmQuotationsMethod.ReplacementValueFirmQuotationsMethodBuilder result;
			if (firmQuotations!=null) {
				result = firmQuotations;
			}
			else {
				result = firmQuotations = ReplacementValueFirmQuotationsMethod.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("calculationAgentDetermination")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("calculationAgentDetermination")
		public ReplacementValueCalculationAgentDeterminationMethod.ReplacementValueCalculationAgentDeterminationMethodBuilder getCalculationAgentDetermination() {
			return calculationAgentDetermination;
		}
		
		@Override
		public ReplacementValueCalculationAgentDeterminationMethod.ReplacementValueCalculationAgentDeterminationMethodBuilder getOrCreateCalculationAgentDetermination() {
			ReplacementValueCalculationAgentDeterminationMethod.ReplacementValueCalculationAgentDeterminationMethodBuilder result;
			if (calculationAgentDetermination!=null) {
				result = calculationAgentDetermination;
			}
			else {
				result = calculationAgentDetermination = ReplacementValueCalculationAgentDeterminationMethod.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("firmQuotations")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("firmQuotations")
		@Override
		public ReplacementValue.ReplacementValueBuilder setFirmQuotations(ReplacementValueFirmQuotationsMethod _firmQuotations) {
			this.firmQuotations = _firmQuotations == null ? null : _firmQuotations.toBuilder();
			return this;
		}
		
		@RosettaAttribute("calculationAgentDetermination")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("calculationAgentDetermination")
		@Override
		public ReplacementValue.ReplacementValueBuilder setCalculationAgentDetermination(ReplacementValueCalculationAgentDeterminationMethod _calculationAgentDetermination) {
			this.calculationAgentDetermination = _calculationAgentDetermination == null ? null : _calculationAgentDetermination.toBuilder();
			return this;
		}
		
		@Override
		public ReplacementValue build() {
			return new ReplacementValue.ReplacementValueImpl(this);
		}
		
		@Override
		public ReplacementValue.ReplacementValueBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReplacementValue.ReplacementValueBuilder prune() {
			if (firmQuotations!=null && !firmQuotations.prune().hasData()) firmQuotations = null;
			if (calculationAgentDetermination!=null && !calculationAgentDetermination.prune().hasData()) calculationAgentDetermination = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getFirmQuotations()!=null && getFirmQuotations().hasData()) return true;
			if (getCalculationAgentDetermination()!=null && getCalculationAgentDetermination().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReplacementValue.ReplacementValueBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ReplacementValue.ReplacementValueBuilder o = (ReplacementValue.ReplacementValueBuilder) other;
			
			merger.mergeRosetta(getFirmQuotations(), o.getFirmQuotations(), this::setFirmQuotations);
			merger.mergeRosetta(getCalculationAgentDetermination(), o.getCalculationAgentDetermination(), this::setCalculationAgentDetermination);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ReplacementValue _that = getType().cast(o);
		
			if (!Objects.equals(firmQuotations, _that.getFirmQuotations())) return false;
			if (!Objects.equals(calculationAgentDetermination, _that.getCalculationAgentDetermination())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (firmQuotations != null ? firmQuotations.hashCode() : 0);
			_result = 31 * _result + (calculationAgentDetermination != null ? calculationAgentDetermination.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReplacementValueBuilder {" +
				"firmQuotations=" + this.firmQuotations + ", " +
				"calculationAgentDetermination=" + this.calculationAgentDetermination +
			'}';
		}
	}
}
