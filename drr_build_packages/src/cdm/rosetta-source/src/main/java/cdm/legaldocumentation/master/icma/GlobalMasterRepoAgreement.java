package cdm.legaldocumentation.master.icma;

import cdm.legaldocumentation.master.MasterAgreementBase;
import cdm.legaldocumentation.master.icma.meta.GlobalMasterRepoAgreementMeta;
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
 * The set of elections that define a GMRA
 * @version 6.23.0
 */
@RosettaDataType(value="GlobalMasterRepoAgreement", builder=GlobalMasterRepoAgreement.GlobalMasterRepoAgreementBuilderImpl.class, version="6.23.0")
@RuneDataType(value="GlobalMasterRepoAgreement", model="cdm", builder=GlobalMasterRepoAgreement.GlobalMasterRepoAgreementBuilderImpl.class, version="6.23.0")
public interface GlobalMasterRepoAgreement extends MasterAgreementBase {

	GlobalMasterRepoAgreementMeta metaData = new GlobalMasterRepoAgreementMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	GlobalMasterRepoAgreement build();
	
	GlobalMasterRepoAgreement.GlobalMasterRepoAgreementBuilder toBuilder();
	
	static GlobalMasterRepoAgreement.GlobalMasterRepoAgreementBuilder builder() {
		return new GlobalMasterRepoAgreement.GlobalMasterRepoAgreementBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends GlobalMasterRepoAgreement> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends GlobalMasterRepoAgreement> getType() {
		return GlobalMasterRepoAgreement.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
	}
	

	/*********************** Builder Interface  ***********************/
	interface GlobalMasterRepoAgreementBuilder extends GlobalMasterRepoAgreement, MasterAgreementBase.MasterAgreementBaseBuilder {

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
		}
		

		GlobalMasterRepoAgreement.GlobalMasterRepoAgreementBuilder prune();
	}

	/*********************** Immutable Implementation of GlobalMasterRepoAgreement  ***********************/
	class GlobalMasterRepoAgreementImpl extends MasterAgreementBase.MasterAgreementBaseImpl implements GlobalMasterRepoAgreement {
		
		protected GlobalMasterRepoAgreementImpl(GlobalMasterRepoAgreement.GlobalMasterRepoAgreementBuilder builder) {
			super(builder);
		}
		
		@Override
		public GlobalMasterRepoAgreement build() {
			return this;
		}
		
		@Override
		public GlobalMasterRepoAgreement.GlobalMasterRepoAgreementBuilder toBuilder() {
			GlobalMasterRepoAgreement.GlobalMasterRepoAgreementBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(GlobalMasterRepoAgreement.GlobalMasterRepoAgreementBuilder builder) {
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
			return "GlobalMasterRepoAgreement {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of GlobalMasterRepoAgreement  ***********************/
	class GlobalMasterRepoAgreementBuilderImpl extends MasterAgreementBase.MasterAgreementBaseBuilderImpl implements GlobalMasterRepoAgreement.GlobalMasterRepoAgreementBuilder {
	
		
		@Override
		public GlobalMasterRepoAgreement build() {
			return new GlobalMasterRepoAgreement.GlobalMasterRepoAgreementImpl(this);
		}
		
		@Override
		public GlobalMasterRepoAgreement.GlobalMasterRepoAgreementBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public GlobalMasterRepoAgreement.GlobalMasterRepoAgreementBuilder prune() {
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
		public GlobalMasterRepoAgreement.GlobalMasterRepoAgreementBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			GlobalMasterRepoAgreement.GlobalMasterRepoAgreementBuilder o = (GlobalMasterRepoAgreement.GlobalMasterRepoAgreementBuilder) other;
			
			
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
			return "GlobalMasterRepoAgreementBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
