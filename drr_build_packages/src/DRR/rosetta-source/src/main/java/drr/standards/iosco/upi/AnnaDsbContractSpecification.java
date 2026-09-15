package drr.standards.iosco.upi;

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
import drr.standards.iosco.upi.meta.AnnaDsbContractSpecificationMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 7.7.0
 */
@RosettaDataType(value="AnnaDsbContractSpecification", builder=AnnaDsbContractSpecification.AnnaDsbContractSpecificationBuilderImpl.class, version="7.7.0")
@RuneDataType(value="AnnaDsbContractSpecification", model="drr", builder=AnnaDsbContractSpecification.AnnaDsbContractSpecificationBuilderImpl.class, version="7.7.0")
public interface AnnaDsbContractSpecification extends RosettaModelObject {

	AnnaDsbContractSpecificationMeta metaData = new AnnaDsbContractSpecificationMeta();

	/*********************** Getter Methods  ***********************/
	AnnaDsbContractSpecificationEnum getContractSpecification();
	String getNoContractSpecification();

	/*********************** Build Methods  ***********************/
	AnnaDsbContractSpecification build();
	
	AnnaDsbContractSpecification.AnnaDsbContractSpecificationBuilder toBuilder();
	
	static AnnaDsbContractSpecification.AnnaDsbContractSpecificationBuilder builder() {
		return new AnnaDsbContractSpecification.AnnaDsbContractSpecificationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AnnaDsbContractSpecification> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AnnaDsbContractSpecification> getType() {
		return AnnaDsbContractSpecification.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("ContractSpecification"), AnnaDsbContractSpecificationEnum.class, getContractSpecification(), this);
		processor.processBasic(path.newSubPath("noContractSpecification"), String.class, getNoContractSpecification(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface AnnaDsbContractSpecificationBuilder extends AnnaDsbContractSpecification, RosettaModelObjectBuilder {
		AnnaDsbContractSpecification.AnnaDsbContractSpecificationBuilder setContractSpecification(AnnaDsbContractSpecificationEnum ContractSpecification);
		AnnaDsbContractSpecification.AnnaDsbContractSpecificationBuilder setNoContractSpecification(String noContractSpecification);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("ContractSpecification"), AnnaDsbContractSpecificationEnum.class, getContractSpecification(), this);
			processor.processBasic(path.newSubPath("noContractSpecification"), String.class, getNoContractSpecification(), this);
		}
		

		AnnaDsbContractSpecification.AnnaDsbContractSpecificationBuilder prune();
	}

	/*********************** Immutable Implementation of AnnaDsbContractSpecification  ***********************/
	class AnnaDsbContractSpecificationImpl implements AnnaDsbContractSpecification {
		private final AnnaDsbContractSpecificationEnum contractSpecification;
		private final String noContractSpecification;
		
		protected AnnaDsbContractSpecificationImpl(AnnaDsbContractSpecification.AnnaDsbContractSpecificationBuilder builder) {
			this.contractSpecification = builder.getContractSpecification();
			this.noContractSpecification = builder.getNoContractSpecification();
		}
		
		@Override
		@RosettaAttribute("ContractSpecification")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("ContractSpecification")
		public AnnaDsbContractSpecificationEnum getContractSpecification() {
			return contractSpecification;
		}
		
		@Override
		@RosettaAttribute("noContractSpecification")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("noContractSpecification")
		public String getNoContractSpecification() {
			return noContractSpecification;
		}
		
		@Override
		public AnnaDsbContractSpecification build() {
			return this;
		}
		
		@Override
		public AnnaDsbContractSpecification.AnnaDsbContractSpecificationBuilder toBuilder() {
			AnnaDsbContractSpecification.AnnaDsbContractSpecificationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AnnaDsbContractSpecification.AnnaDsbContractSpecificationBuilder builder) {
			ofNullable(getContractSpecification()).ifPresent(builder::setContractSpecification);
			ofNullable(getNoContractSpecification()).ifPresent(builder::setNoContractSpecification);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AnnaDsbContractSpecification _that = getType().cast(o);
		
			if (!Objects.equals(contractSpecification, _that.getContractSpecification())) return false;
			if (!Objects.equals(noContractSpecification, _that.getNoContractSpecification())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (contractSpecification != null ? contractSpecification.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (noContractSpecification != null ? noContractSpecification.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AnnaDsbContractSpecification {" +
				"ContractSpecification=" + this.contractSpecification + ", " +
				"noContractSpecification=" + this.noContractSpecification +
			'}';
		}
	}

	/*********************** Builder Implementation of AnnaDsbContractSpecification  ***********************/
	class AnnaDsbContractSpecificationBuilderImpl implements AnnaDsbContractSpecification.AnnaDsbContractSpecificationBuilder {
	
		protected AnnaDsbContractSpecificationEnum contractSpecification;
		protected String noContractSpecification;
		
		@Override
		@RosettaAttribute("ContractSpecification")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("ContractSpecification")
		public AnnaDsbContractSpecificationEnum getContractSpecification() {
			return contractSpecification;
		}
		
		@Override
		@RosettaAttribute("noContractSpecification")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("noContractSpecification")
		public String getNoContractSpecification() {
			return noContractSpecification;
		}
		
		@RosettaAttribute("ContractSpecification")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("ContractSpecification")
		@Override
		public AnnaDsbContractSpecification.AnnaDsbContractSpecificationBuilder setContractSpecification(AnnaDsbContractSpecificationEnum _contractSpecification) {
			this.contractSpecification = _contractSpecification == null ? null : _contractSpecification;
			return this;
		}
		
		@RosettaAttribute("noContractSpecification")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("noContractSpecification")
		@Override
		public AnnaDsbContractSpecification.AnnaDsbContractSpecificationBuilder setNoContractSpecification(String _noContractSpecification) {
			this.noContractSpecification = _noContractSpecification == null ? null : _noContractSpecification;
			return this;
		}
		
		@Override
		public AnnaDsbContractSpecification build() {
			return new AnnaDsbContractSpecification.AnnaDsbContractSpecificationImpl(this);
		}
		
		@Override
		public AnnaDsbContractSpecification.AnnaDsbContractSpecificationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AnnaDsbContractSpecification.AnnaDsbContractSpecificationBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getContractSpecification()!=null) return true;
			if (getNoContractSpecification()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AnnaDsbContractSpecification.AnnaDsbContractSpecificationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AnnaDsbContractSpecification.AnnaDsbContractSpecificationBuilder o = (AnnaDsbContractSpecification.AnnaDsbContractSpecificationBuilder) other;
			
			
			merger.mergeBasic(getContractSpecification(), o.getContractSpecification(), this::setContractSpecification);
			merger.mergeBasic(getNoContractSpecification(), o.getNoContractSpecification(), this::setNoContractSpecification);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AnnaDsbContractSpecification _that = getType().cast(o);
		
			if (!Objects.equals(contractSpecification, _that.getContractSpecification())) return false;
			if (!Objects.equals(noContractSpecification, _that.getNoContractSpecification())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (contractSpecification != null ? contractSpecification.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (noContractSpecification != null ? noContractSpecification.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AnnaDsbContractSpecificationBuilder {" +
				"ContractSpecification=" + this.contractSpecification + ", " +
				"noContractSpecification=" + this.noContractSpecification +
			'}';
		}
	}
}
