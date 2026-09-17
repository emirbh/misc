package cdm.legaldocumentation.csa;

import cdm.legaldocumentation.csa.meta.CSAMinimumTransferAmountMeta;
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
 * name "Minimum Transfer Amount"
 *
 * Provision 
 *
 *
 * Body ISDA
 * Corpus Annex CSA_English_1995 1995 English Law Credit Support Annex  
 * name "Minimum Transfer Amount"
 *
 * Provision 
 *
 *
 * Body ISDA
 * Corpus Deed CSD_English_1995 1995 English Law Credit Support Deed  
 * name "Minimum Transfer Amount"
 *
 * Provision 
 *
 *
 * Body ISDA
 * Corpus Annex CSA_VM_English_2016 2016 English Law Variation Margin Credit Support Annex  
 * name "Minimum Transfer Amount"
 *
 * Provision 
 *
 *
 * Body ISDA
 * Corpus Annex CSA_VM_NewYork_2016 2016 New York Law Variation Margin Credit Support Annex  
 * name "Minimum Transfer Amount"
 *
 * Provision 
 *
 */
@RosettaDataType(value="CSAMinimumTransferAmount", builder=CSAMinimumTransferAmount.CSAMinimumTransferAmountBuilderImpl.class, version="6.23.0")
@RuneDataType(value="CSAMinimumTransferAmount", model="cdm", builder=CSAMinimumTransferAmount.CSAMinimumTransferAmountBuilderImpl.class, version="6.23.0")
public interface CSAMinimumTransferAmount extends RosettaModelObject {

	CSAMinimumTransferAmountMeta metaData = new CSAMinimumTransferAmountMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Details whether the Minimum Transfer Amount (MTA) is rating based, a fixed amount, or infinity.
	 */
	MTAType getMtaType();

	/*********************** Build Methods  ***********************/
	CSAMinimumTransferAmount build();
	
	CSAMinimumTransferAmount.CSAMinimumTransferAmountBuilder toBuilder();
	
	static CSAMinimumTransferAmount.CSAMinimumTransferAmountBuilder builder() {
		return new CSAMinimumTransferAmount.CSAMinimumTransferAmountBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CSAMinimumTransferAmount> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CSAMinimumTransferAmount> getType() {
		return CSAMinimumTransferAmount.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("mtaType"), processor, MTAType.class, getMtaType());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CSAMinimumTransferAmountBuilder extends CSAMinimumTransferAmount, RosettaModelObjectBuilder {
		MTAType.MTATypeBuilder getOrCreateMtaType();
		@Override
		MTAType.MTATypeBuilder getMtaType();
		CSAMinimumTransferAmount.CSAMinimumTransferAmountBuilder setMtaType(MTAType mtaType);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("mtaType"), processor, MTAType.MTATypeBuilder.class, getMtaType());
		}
		

		CSAMinimumTransferAmount.CSAMinimumTransferAmountBuilder prune();
	}

	/*********************** Immutable Implementation of CSAMinimumTransferAmount  ***********************/
	class CSAMinimumTransferAmountImpl implements CSAMinimumTransferAmount {
		private final MTAType mtaType;
		
		protected CSAMinimumTransferAmountImpl(CSAMinimumTransferAmount.CSAMinimumTransferAmountBuilder builder) {
			this.mtaType = ofNullable(builder.getMtaType()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("mtaType")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("mtaType")
		public MTAType getMtaType() {
			return mtaType;
		}
		
		@Override
		public CSAMinimumTransferAmount build() {
			return this;
		}
		
		@Override
		public CSAMinimumTransferAmount.CSAMinimumTransferAmountBuilder toBuilder() {
			CSAMinimumTransferAmount.CSAMinimumTransferAmountBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CSAMinimumTransferAmount.CSAMinimumTransferAmountBuilder builder) {
			ofNullable(getMtaType()).ifPresent(builder::setMtaType);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CSAMinimumTransferAmount _that = getType().cast(o);
		
			if (!Objects.equals(mtaType, _that.getMtaType())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (mtaType != null ? mtaType.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CSAMinimumTransferAmount {" +
				"mtaType=" + this.mtaType +
			'}';
		}
	}

	/*********************** Builder Implementation of CSAMinimumTransferAmount  ***********************/
	class CSAMinimumTransferAmountBuilderImpl implements CSAMinimumTransferAmount.CSAMinimumTransferAmountBuilder {
	
		protected MTAType.MTATypeBuilder mtaType;
		
		@Override
		@RosettaAttribute("mtaType")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("mtaType")
		public MTAType.MTATypeBuilder getMtaType() {
			return mtaType;
		}
		
		@Override
		public MTAType.MTATypeBuilder getOrCreateMtaType() {
			MTAType.MTATypeBuilder result;
			if (mtaType!=null) {
				result = mtaType;
			}
			else {
				result = mtaType = MTAType.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("mtaType")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("mtaType")
		@Override
		public CSAMinimumTransferAmount.CSAMinimumTransferAmountBuilder setMtaType(MTAType _mtaType) {
			this.mtaType = _mtaType == null ? null : _mtaType.toBuilder();
			return this;
		}
		
		@Override
		public CSAMinimumTransferAmount build() {
			return new CSAMinimumTransferAmount.CSAMinimumTransferAmountImpl(this);
		}
		
		@Override
		public CSAMinimumTransferAmount.CSAMinimumTransferAmountBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CSAMinimumTransferAmount.CSAMinimumTransferAmountBuilder prune() {
			if (mtaType!=null && !mtaType.prune().hasData()) mtaType = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getMtaType()!=null && getMtaType().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CSAMinimumTransferAmount.CSAMinimumTransferAmountBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CSAMinimumTransferAmount.CSAMinimumTransferAmountBuilder o = (CSAMinimumTransferAmount.CSAMinimumTransferAmountBuilder) other;
			
			merger.mergeRosetta(getMtaType(), o.getMtaType(), this::setMtaType);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CSAMinimumTransferAmount _that = getType().cast(o);
		
			if (!Objects.equals(mtaType, _that.getMtaType())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (mtaType != null ? mtaType.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CSAMinimumTransferAmountBuilder {" +
				"mtaType=" + this.mtaType +
			'}';
		}
	}
}
