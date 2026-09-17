package cdm.legaldocumentation.master;

import cdm.legaldocumentation.master.meta.MasterAgreementBaseMeta;
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
 * A set of elections that can be shared across master agreement types - this should be built upon for specific contracts.
 * @version 6.23.0
 */
@RosettaDataType(value="MasterAgreementBase", builder=MasterAgreementBase.MasterAgreementBaseBuilderImpl.class, version="6.23.0")
@RuneDataType(value="MasterAgreementBase", model="cdm", builder=MasterAgreementBase.MasterAgreementBaseBuilderImpl.class, version="6.23.0")
public interface MasterAgreementBase extends RosettaModelObject {

	MasterAgreementBaseMeta metaData = new MasterAgreementBaseMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	MasterAgreementBase build();
	
	MasterAgreementBase.MasterAgreementBaseBuilder toBuilder();
	
	static MasterAgreementBase.MasterAgreementBaseBuilder builder() {
		return new MasterAgreementBase.MasterAgreementBaseBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends MasterAgreementBase> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends MasterAgreementBase> getType() {
		return MasterAgreementBase.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
	}
	

	/*********************** Builder Interface  ***********************/
	interface MasterAgreementBaseBuilder extends MasterAgreementBase, RosettaModelObjectBuilder {

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
		}
		

		MasterAgreementBase.MasterAgreementBaseBuilder prune();
	}

	/*********************** Immutable Implementation of MasterAgreementBase  ***********************/
	class MasterAgreementBaseImpl implements MasterAgreementBase {
		
		protected MasterAgreementBaseImpl(MasterAgreementBase.MasterAgreementBaseBuilder builder) {
		}
		
		@Override
		public MasterAgreementBase build() {
			return this;
		}
		
		@Override
		public MasterAgreementBase.MasterAgreementBaseBuilder toBuilder() {
			MasterAgreementBase.MasterAgreementBaseBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(MasterAgreementBase.MasterAgreementBaseBuilder builder) {
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
		
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			return _result;
		}
		
		@Override
		public String toString() {
			return "MasterAgreementBase {" +
			'}';
		}
	}

	/*********************** Builder Implementation of MasterAgreementBase  ***********************/
	class MasterAgreementBaseBuilderImpl implements MasterAgreementBase.MasterAgreementBaseBuilder {
	
		
		@Override
		public MasterAgreementBase build() {
			return new MasterAgreementBase.MasterAgreementBaseImpl(this);
		}
		
		@Override
		public MasterAgreementBase.MasterAgreementBaseBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MasterAgreementBase.MasterAgreementBaseBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MasterAgreementBase.MasterAgreementBaseBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			MasterAgreementBase.MasterAgreementBaseBuilder o = (MasterAgreementBase.MasterAgreementBaseBuilder) other;
			
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
		
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			return _result;
		}
		
		@Override
		public String toString() {
			return "MasterAgreementBaseBuilder {" +
			'}';
		}
	}
}
