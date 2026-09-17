package cdm.observable.asset.fro;

import cdm.legaldocumentation.common.ContractualDefinitionsEnum;
import cdm.observable.asset.fro.meta.ContractualDefinitionIdentifierMeta;
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
 */
@RosettaDataType(value="ContractualDefinitionIdentifier", builder=ContractualDefinitionIdentifier.ContractualDefinitionIdentifierBuilderImpl.class, version="6.23.0")
@RuneDataType(value="ContractualDefinitionIdentifier", model="cdm", builder=ContractualDefinitionIdentifier.ContractualDefinitionIdentifierBuilderImpl.class, version="6.23.0")
public interface ContractualDefinitionIdentifier extends RosettaModelObject {

	ContractualDefinitionIdentifierMeta metaData = new ContractualDefinitionIdentifierMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * e.g. ISDA2021Definitions
	 */
	ContractualDefinitionsEnum getContractualDefinitionType();
	/**
	 * e.g. V1
	 */
	String getContractualDefinitionVersion();

	/*********************** Build Methods  ***********************/
	ContractualDefinitionIdentifier build();
	
	ContractualDefinitionIdentifier.ContractualDefinitionIdentifierBuilder toBuilder();
	
	static ContractualDefinitionIdentifier.ContractualDefinitionIdentifierBuilder builder() {
		return new ContractualDefinitionIdentifier.ContractualDefinitionIdentifierBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ContractualDefinitionIdentifier> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ContractualDefinitionIdentifier> getType() {
		return ContractualDefinitionIdentifier.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("contractualDefinitionType"), ContractualDefinitionsEnum.class, getContractualDefinitionType(), this);
		processor.processBasic(path.newSubPath("contractualDefinitionVersion"), String.class, getContractualDefinitionVersion(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ContractualDefinitionIdentifierBuilder extends ContractualDefinitionIdentifier, RosettaModelObjectBuilder {
		ContractualDefinitionIdentifier.ContractualDefinitionIdentifierBuilder setContractualDefinitionType(ContractualDefinitionsEnum contractualDefinitionType);
		ContractualDefinitionIdentifier.ContractualDefinitionIdentifierBuilder setContractualDefinitionVersion(String contractualDefinitionVersion);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("contractualDefinitionType"), ContractualDefinitionsEnum.class, getContractualDefinitionType(), this);
			processor.processBasic(path.newSubPath("contractualDefinitionVersion"), String.class, getContractualDefinitionVersion(), this);
		}
		

		ContractualDefinitionIdentifier.ContractualDefinitionIdentifierBuilder prune();
	}

	/*********************** Immutable Implementation of ContractualDefinitionIdentifier  ***********************/
	class ContractualDefinitionIdentifierImpl implements ContractualDefinitionIdentifier {
		private final ContractualDefinitionsEnum contractualDefinitionType;
		private final String contractualDefinitionVersion;
		
		protected ContractualDefinitionIdentifierImpl(ContractualDefinitionIdentifier.ContractualDefinitionIdentifierBuilder builder) {
			this.contractualDefinitionType = builder.getContractualDefinitionType();
			this.contractualDefinitionVersion = builder.getContractualDefinitionVersion();
		}
		
		@Override
		@RosettaAttribute("contractualDefinitionType")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("contractualDefinitionType")
		public ContractualDefinitionsEnum getContractualDefinitionType() {
			return contractualDefinitionType;
		}
		
		@Override
		@RosettaAttribute("contractualDefinitionVersion")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("contractualDefinitionVersion")
		public String getContractualDefinitionVersion() {
			return contractualDefinitionVersion;
		}
		
		@Override
		public ContractualDefinitionIdentifier build() {
			return this;
		}
		
		@Override
		public ContractualDefinitionIdentifier.ContractualDefinitionIdentifierBuilder toBuilder() {
			ContractualDefinitionIdentifier.ContractualDefinitionIdentifierBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ContractualDefinitionIdentifier.ContractualDefinitionIdentifierBuilder builder) {
			ofNullable(getContractualDefinitionType()).ifPresent(builder::setContractualDefinitionType);
			ofNullable(getContractualDefinitionVersion()).ifPresent(builder::setContractualDefinitionVersion);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ContractualDefinitionIdentifier _that = getType().cast(o);
		
			if (!Objects.equals(contractualDefinitionType, _that.getContractualDefinitionType())) return false;
			if (!Objects.equals(contractualDefinitionVersion, _that.getContractualDefinitionVersion())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (contractualDefinitionType != null ? contractualDefinitionType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (contractualDefinitionVersion != null ? contractualDefinitionVersion.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ContractualDefinitionIdentifier {" +
				"contractualDefinitionType=" + this.contractualDefinitionType + ", " +
				"contractualDefinitionVersion=" + this.contractualDefinitionVersion +
			'}';
		}
	}

	/*********************** Builder Implementation of ContractualDefinitionIdentifier  ***********************/
	class ContractualDefinitionIdentifierBuilderImpl implements ContractualDefinitionIdentifier.ContractualDefinitionIdentifierBuilder {
	
		protected ContractualDefinitionsEnum contractualDefinitionType;
		protected String contractualDefinitionVersion;
		
		@Override
		@RosettaAttribute("contractualDefinitionType")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("contractualDefinitionType")
		public ContractualDefinitionsEnum getContractualDefinitionType() {
			return contractualDefinitionType;
		}
		
		@Override
		@RosettaAttribute("contractualDefinitionVersion")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("contractualDefinitionVersion")
		public String getContractualDefinitionVersion() {
			return contractualDefinitionVersion;
		}
		
		@RosettaAttribute("contractualDefinitionType")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("contractualDefinitionType")
		@Override
		public ContractualDefinitionIdentifier.ContractualDefinitionIdentifierBuilder setContractualDefinitionType(ContractualDefinitionsEnum _contractualDefinitionType) {
			this.contractualDefinitionType = _contractualDefinitionType == null ? null : _contractualDefinitionType;
			return this;
		}
		
		@RosettaAttribute("contractualDefinitionVersion")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("contractualDefinitionVersion")
		@Override
		public ContractualDefinitionIdentifier.ContractualDefinitionIdentifierBuilder setContractualDefinitionVersion(String _contractualDefinitionVersion) {
			this.contractualDefinitionVersion = _contractualDefinitionVersion == null ? null : _contractualDefinitionVersion;
			return this;
		}
		
		@Override
		public ContractualDefinitionIdentifier build() {
			return new ContractualDefinitionIdentifier.ContractualDefinitionIdentifierImpl(this);
		}
		
		@Override
		public ContractualDefinitionIdentifier.ContractualDefinitionIdentifierBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ContractualDefinitionIdentifier.ContractualDefinitionIdentifierBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getContractualDefinitionType()!=null) return true;
			if (getContractualDefinitionVersion()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ContractualDefinitionIdentifier.ContractualDefinitionIdentifierBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ContractualDefinitionIdentifier.ContractualDefinitionIdentifierBuilder o = (ContractualDefinitionIdentifier.ContractualDefinitionIdentifierBuilder) other;
			
			
			merger.mergeBasic(getContractualDefinitionType(), o.getContractualDefinitionType(), this::setContractualDefinitionType);
			merger.mergeBasic(getContractualDefinitionVersion(), o.getContractualDefinitionVersion(), this::setContractualDefinitionVersion);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ContractualDefinitionIdentifier _that = getType().cast(o);
		
			if (!Objects.equals(contractualDefinitionType, _that.getContractualDefinitionType())) return false;
			if (!Objects.equals(contractualDefinitionVersion, _that.getContractualDefinitionVersion())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (contractualDefinitionType != null ? contractualDefinitionType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (contractualDefinitionVersion != null ? contractualDefinitionVersion.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ContractualDefinitionIdentifierBuilder {" +
				"contractualDefinitionType=" + this.contractualDefinitionType + ", " +
				"contractualDefinitionVersion=" + this.contractualDefinitionVersion +
			'}';
		}
	}
}
