package cdm.legaldocumentation.master.isla;

import cdm.legaldocumentation.master.MasterAgreementBase;
import cdm.legaldocumentation.master.isla.meta.GlobalMasterSecuritiesLendingAgreementMeta;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;


/**
 * The set of elections that define a GMSLA.
 * @version 6.23.0
 */
@RosettaDataType(value="GlobalMasterSecuritiesLendingAgreement", builder=GlobalMasterSecuritiesLendingAgreement.GlobalMasterSecuritiesLendingAgreementBuilderImpl.class, version="6.23.0")
@RuneDataType(value="GlobalMasterSecuritiesLendingAgreement", model="cdm", builder=GlobalMasterSecuritiesLendingAgreement.GlobalMasterSecuritiesLendingAgreementBuilderImpl.class, version="6.23.0")
public interface GlobalMasterSecuritiesLendingAgreement extends MasterAgreementBase {

	GlobalMasterSecuritiesLendingAgreementMeta metaData = new GlobalMasterSecuritiesLendingAgreementMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	GlobalMasterSecuritiesLendingAgreement build();
	
	GlobalMasterSecuritiesLendingAgreement.GlobalMasterSecuritiesLendingAgreementBuilder toBuilder();
	
	static GlobalMasterSecuritiesLendingAgreement.GlobalMasterSecuritiesLendingAgreementBuilder builder() {
		return new GlobalMasterSecuritiesLendingAgreement.GlobalMasterSecuritiesLendingAgreementBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends GlobalMasterSecuritiesLendingAgreement> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends GlobalMasterSecuritiesLendingAgreement> getType() {
		return GlobalMasterSecuritiesLendingAgreement.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
	}
	

	/*********************** Builder Interface  ***********************/
	interface GlobalMasterSecuritiesLendingAgreementBuilder extends GlobalMasterSecuritiesLendingAgreement, MasterAgreementBase.MasterAgreementBaseBuilder {

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
		}
		

		GlobalMasterSecuritiesLendingAgreement.GlobalMasterSecuritiesLendingAgreementBuilder prune();
	}

	/*********************** Immutable Implementation of GlobalMasterSecuritiesLendingAgreement  ***********************/
	class GlobalMasterSecuritiesLendingAgreementImpl extends MasterAgreementBase.MasterAgreementBaseImpl implements GlobalMasterSecuritiesLendingAgreement {
		
		protected GlobalMasterSecuritiesLendingAgreementImpl(GlobalMasterSecuritiesLendingAgreement.GlobalMasterSecuritiesLendingAgreementBuilder builder) {
			super(builder);
		}
		
		@Override
		public GlobalMasterSecuritiesLendingAgreement build() {
			return this;
		}
		
		@Override
		public GlobalMasterSecuritiesLendingAgreement.GlobalMasterSecuritiesLendingAgreementBuilder toBuilder() {
			GlobalMasterSecuritiesLendingAgreement.GlobalMasterSecuritiesLendingAgreementBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(GlobalMasterSecuritiesLendingAgreement.GlobalMasterSecuritiesLendingAgreementBuilder builder) {
			super.setBuilderFields(builder);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
		
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			return _result;
		}
		
		@Override
		public String toString() {
			return "GlobalMasterSecuritiesLendingAgreement {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of GlobalMasterSecuritiesLendingAgreement  ***********************/
	class GlobalMasterSecuritiesLendingAgreementBuilderImpl extends MasterAgreementBase.MasterAgreementBaseBuilderImpl implements GlobalMasterSecuritiesLendingAgreement.GlobalMasterSecuritiesLendingAgreementBuilder {
	
		
		@Override
		public GlobalMasterSecuritiesLendingAgreement build() {
			return new GlobalMasterSecuritiesLendingAgreement.GlobalMasterSecuritiesLendingAgreementImpl(this);
		}
		
		@Override
		public GlobalMasterSecuritiesLendingAgreement.GlobalMasterSecuritiesLendingAgreementBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public GlobalMasterSecuritiesLendingAgreement.GlobalMasterSecuritiesLendingAgreementBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public GlobalMasterSecuritiesLendingAgreement.GlobalMasterSecuritiesLendingAgreementBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			GlobalMasterSecuritiesLendingAgreement.GlobalMasterSecuritiesLendingAgreementBuilder o = (GlobalMasterSecuritiesLendingAgreement.GlobalMasterSecuritiesLendingAgreementBuilder) other;
			
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
		
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			return _result;
		}
		
		@Override
		public String toString() {
			return "GlobalMasterSecuritiesLendingAgreementBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
