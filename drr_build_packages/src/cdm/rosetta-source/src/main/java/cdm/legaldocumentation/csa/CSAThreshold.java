package cdm.legaldocumentation.csa;

import cdm.legaldocumentation.csa.meta.CSAThresholdMeta;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
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
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 6.23.0
 *
 * Body ISDA
 * Corpus Annex CSA_NewYork_1994 1994 New York Law Credit Support Annex  
 * name "Threshold"
 *
 * Provision 
 *
 *
 * Body ISDA
 * Corpus Annex CSA_English_1995 1995 English Law Credit Support Annex  
 * name "Threshold"
 *
 * Provision 
 *
 *
 * Body ISDA
 * Corpus Deed CSD_English_1995 1995 English Law Credit Support Deed  
 * name "Threshold"
 *
 * Provision 
 *
 *
 * Body ISDA
 * Corpus Annex CSA_VM_English_2016 2016 English Law Variation Margin Credit Support Annex  
 * name "Threshold"
 *
 * Provision 
 *
 *
 * Body ISDA
 * Corpus Annex CSA_VM_NewYork_2016 2016 New York Law Variation Margin Credit Support Annex  
 * name "Threshold"
 *
 * Provision 
 *
 */
@RosettaDataType(value="CSAThreshold", builder=CSAThreshold.CSAThresholdBuilderImpl.class, version="6.23.0")
@RuneDataType(value="CSAThreshold", model="cdm", builder=CSAThreshold.CSAThresholdBuilderImpl.class, version="6.23.0")
public interface CSAThreshold extends RosettaModelObject {

	CSAThresholdMeta metaData = new CSAThresholdMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Details whether the threshold is rating based, a fixed amount, or infinity.
	 */
	ThresholdType getThresholdType();

	/*********************** Build Methods  ***********************/
	CSAThreshold build();
	
	CSAThreshold.CSAThresholdBuilder toBuilder();
	
	static CSAThreshold.CSAThresholdBuilder builder() {
		return new CSAThreshold.CSAThresholdBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CSAThreshold> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CSAThreshold> getType() {
		return CSAThreshold.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("thresholdType"), processor, ThresholdType.class, getThresholdType());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CSAThresholdBuilder extends CSAThreshold, RosettaModelObjectBuilder {
		ThresholdType.ThresholdTypeBuilder getOrCreateThresholdType();
		@Override
		ThresholdType.ThresholdTypeBuilder getThresholdType();
		CSAThreshold.CSAThresholdBuilder setThresholdType(ThresholdType thresholdType);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("thresholdType"), processor, ThresholdType.ThresholdTypeBuilder.class, getThresholdType());
		}
		

		CSAThreshold.CSAThresholdBuilder prune();
	}

	/*********************** Immutable Implementation of CSAThreshold  ***********************/
	class CSAThresholdImpl implements CSAThreshold {
		private final ThresholdType thresholdType;
		
		protected CSAThresholdImpl(CSAThreshold.CSAThresholdBuilder builder) {
			this.thresholdType = ofNullable(builder.getThresholdType()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("thresholdType")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("thresholdType")
		public ThresholdType getThresholdType() {
			return thresholdType;
		}
		
		@Override
		public CSAThreshold build() {
			return this;
		}
		
		@Override
		public CSAThreshold.CSAThresholdBuilder toBuilder() {
			CSAThreshold.CSAThresholdBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CSAThreshold.CSAThresholdBuilder builder) {
			ofNullable(getThresholdType()).ifPresent(builder::setThresholdType);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CSAThreshold _that = getType().cast(o);
		
			if (!Objects.equals(thresholdType, _that.getThresholdType())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (thresholdType != null ? thresholdType.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CSAThreshold {" +
				"thresholdType=" + this.thresholdType +
			'}';
		}
	}

	/*********************** Builder Implementation of CSAThreshold  ***********************/
	class CSAThresholdBuilderImpl implements CSAThreshold.CSAThresholdBuilder {
	
		protected ThresholdType.ThresholdTypeBuilder thresholdType;
		
		@Override
		@RosettaAttribute("thresholdType")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("thresholdType")
		public ThresholdType.ThresholdTypeBuilder getThresholdType() {
			return thresholdType;
		}
		
		@Override
		public ThresholdType.ThresholdTypeBuilder getOrCreateThresholdType() {
			ThresholdType.ThresholdTypeBuilder result;
			if (thresholdType!=null) {
				result = thresholdType;
			}
			else {
				result = thresholdType = ThresholdType.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("thresholdType")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("thresholdType")
		@Override
		public CSAThreshold.CSAThresholdBuilder setThresholdType(ThresholdType _thresholdType) {
			this.thresholdType = _thresholdType == null ? null : _thresholdType.toBuilder();
			return this;
		}
		
		@Override
		public CSAThreshold build() {
			return new CSAThreshold.CSAThresholdImpl(this);
		}
		
		@Override
		public CSAThreshold.CSAThresholdBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CSAThreshold.CSAThresholdBuilder prune() {
			if (thresholdType!=null && !thresholdType.prune().hasData()) thresholdType = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getThresholdType()!=null && getThresholdType().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CSAThreshold.CSAThresholdBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CSAThreshold.CSAThresholdBuilder o = (CSAThreshold.CSAThresholdBuilder) other;
			
			merger.mergeRosetta(getThresholdType(), o.getThresholdType(), this::setThresholdType);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CSAThreshold _that = getType().cast(o);
		
			if (!Objects.equals(thresholdType, _that.getThresholdType())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (thresholdType != null ? thresholdType.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CSAThresholdBuilder {" +
				"thresholdType=" + this.thresholdType +
			'}';
		}
	}
}
