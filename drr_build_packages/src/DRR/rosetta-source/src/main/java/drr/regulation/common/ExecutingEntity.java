package drr.regulation.common;

import cdm.base.staticdata.party.Address;
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
import drr.regulation.common.meta.ExecutingEntityMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 7.7.0
 */
@RosettaDataType(value="ExecutingEntity", builder=ExecutingEntity.ExecutingEntityBuilderImpl.class, version="7.7.0")
@RuneDataType(value="ExecutingEntity", model="drr", builder=ExecutingEntity.ExecutingEntityBuilderImpl.class, version="7.7.0")
public interface ExecutingEntity extends RosettaModelObject {

	ExecutingEntityMeta metaData = new ExecutingEntityMeta();

	/*********************** Getter Methods  ***********************/
	Boolean getIsInvestmentFirm();
	Address getAddressOfBranch();
	Address getAddressOfIncorporation();

	/*********************** Build Methods  ***********************/
	ExecutingEntity build();
	
	ExecutingEntity.ExecutingEntityBuilder toBuilder();
	
	static ExecutingEntity.ExecutingEntityBuilder builder() {
		return new ExecutingEntity.ExecutingEntityBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ExecutingEntity> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ExecutingEntity> getType() {
		return ExecutingEntity.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("isInvestmentFirm"), Boolean.class, getIsInvestmentFirm(), this);
		processRosetta(path.newSubPath("addressOfBranch"), processor, Address.class, getAddressOfBranch());
		processRosetta(path.newSubPath("addressOfIncorporation"), processor, Address.class, getAddressOfIncorporation());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ExecutingEntityBuilder extends ExecutingEntity, RosettaModelObjectBuilder {
		Address.AddressBuilder getOrCreateAddressOfBranch();
		@Override
		Address.AddressBuilder getAddressOfBranch();
		Address.AddressBuilder getOrCreateAddressOfIncorporation();
		@Override
		Address.AddressBuilder getAddressOfIncorporation();
		ExecutingEntity.ExecutingEntityBuilder setIsInvestmentFirm(Boolean isInvestmentFirm);
		ExecutingEntity.ExecutingEntityBuilder setAddressOfBranch(Address addressOfBranch);
		ExecutingEntity.ExecutingEntityBuilder setAddressOfIncorporation(Address addressOfIncorporation);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("isInvestmentFirm"), Boolean.class, getIsInvestmentFirm(), this);
			processRosetta(path.newSubPath("addressOfBranch"), processor, Address.AddressBuilder.class, getAddressOfBranch());
			processRosetta(path.newSubPath("addressOfIncorporation"), processor, Address.AddressBuilder.class, getAddressOfIncorporation());
		}
		

		ExecutingEntity.ExecutingEntityBuilder prune();
	}

	/*********************** Immutable Implementation of ExecutingEntity  ***********************/
	class ExecutingEntityImpl implements ExecutingEntity {
		private final Boolean isInvestmentFirm;
		private final Address addressOfBranch;
		private final Address addressOfIncorporation;
		
		protected ExecutingEntityImpl(ExecutingEntity.ExecutingEntityBuilder builder) {
			this.isInvestmentFirm = builder.getIsInvestmentFirm();
			this.addressOfBranch = ofNullable(builder.getAddressOfBranch()).map(f->f.build()).orElse(null);
			this.addressOfIncorporation = ofNullable(builder.getAddressOfIncorporation()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("isInvestmentFirm")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("isInvestmentFirm")
		public Boolean getIsInvestmentFirm() {
			return isInvestmentFirm;
		}
		
		@Override
		@RosettaAttribute("addressOfBranch")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("addressOfBranch")
		public Address getAddressOfBranch() {
			return addressOfBranch;
		}
		
		@Override
		@RosettaAttribute("addressOfIncorporation")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("addressOfIncorporation")
		public Address getAddressOfIncorporation() {
			return addressOfIncorporation;
		}
		
		@Override
		public ExecutingEntity build() {
			return this;
		}
		
		@Override
		public ExecutingEntity.ExecutingEntityBuilder toBuilder() {
			ExecutingEntity.ExecutingEntityBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ExecutingEntity.ExecutingEntityBuilder builder) {
			ofNullable(getIsInvestmentFirm()).ifPresent(builder::setIsInvestmentFirm);
			ofNullable(getAddressOfBranch()).ifPresent(builder::setAddressOfBranch);
			ofNullable(getAddressOfIncorporation()).ifPresent(builder::setAddressOfIncorporation);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ExecutingEntity _that = getType().cast(o);
		
			if (!Objects.equals(isInvestmentFirm, _that.getIsInvestmentFirm())) return false;
			if (!Objects.equals(addressOfBranch, _that.getAddressOfBranch())) return false;
			if (!Objects.equals(addressOfIncorporation, _that.getAddressOfIncorporation())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (isInvestmentFirm != null ? isInvestmentFirm.hashCode() : 0);
			_result = 31 * _result + (addressOfBranch != null ? addressOfBranch.hashCode() : 0);
			_result = 31 * _result + (addressOfIncorporation != null ? addressOfIncorporation.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ExecutingEntity {" +
				"isInvestmentFirm=" + this.isInvestmentFirm + ", " +
				"addressOfBranch=" + this.addressOfBranch + ", " +
				"addressOfIncorporation=" + this.addressOfIncorporation +
			'}';
		}
	}

	/*********************** Builder Implementation of ExecutingEntity  ***********************/
	class ExecutingEntityBuilderImpl implements ExecutingEntity.ExecutingEntityBuilder {
	
		protected Boolean isInvestmentFirm;
		protected Address.AddressBuilder addressOfBranch;
		protected Address.AddressBuilder addressOfIncorporation;
		
		@Override
		@RosettaAttribute("isInvestmentFirm")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("isInvestmentFirm")
		public Boolean getIsInvestmentFirm() {
			return isInvestmentFirm;
		}
		
		@Override
		@RosettaAttribute("addressOfBranch")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("addressOfBranch")
		public Address.AddressBuilder getAddressOfBranch() {
			return addressOfBranch;
		}
		
		@Override
		public Address.AddressBuilder getOrCreateAddressOfBranch() {
			Address.AddressBuilder result;
			if (addressOfBranch!=null) {
				result = addressOfBranch;
			}
			else {
				result = addressOfBranch = Address.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("addressOfIncorporation")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("addressOfIncorporation")
		public Address.AddressBuilder getAddressOfIncorporation() {
			return addressOfIncorporation;
		}
		
		@Override
		public Address.AddressBuilder getOrCreateAddressOfIncorporation() {
			Address.AddressBuilder result;
			if (addressOfIncorporation!=null) {
				result = addressOfIncorporation;
			}
			else {
				result = addressOfIncorporation = Address.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("isInvestmentFirm")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("isInvestmentFirm")
		@Override
		public ExecutingEntity.ExecutingEntityBuilder setIsInvestmentFirm(Boolean _isInvestmentFirm) {
			this.isInvestmentFirm = _isInvestmentFirm == null ? null : _isInvestmentFirm;
			return this;
		}
		
		@RosettaAttribute("addressOfBranch")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("addressOfBranch")
		@Override
		public ExecutingEntity.ExecutingEntityBuilder setAddressOfBranch(Address _addressOfBranch) {
			this.addressOfBranch = _addressOfBranch == null ? null : _addressOfBranch.toBuilder();
			return this;
		}
		
		@RosettaAttribute("addressOfIncorporation")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("addressOfIncorporation")
		@Override
		public ExecutingEntity.ExecutingEntityBuilder setAddressOfIncorporation(Address _addressOfIncorporation) {
			this.addressOfIncorporation = _addressOfIncorporation == null ? null : _addressOfIncorporation.toBuilder();
			return this;
		}
		
		@Override
		public ExecutingEntity build() {
			return new ExecutingEntity.ExecutingEntityImpl(this);
		}
		
		@Override
		public ExecutingEntity.ExecutingEntityBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ExecutingEntity.ExecutingEntityBuilder prune() {
			if (addressOfBranch!=null && !addressOfBranch.prune().hasData()) addressOfBranch = null;
			if (addressOfIncorporation!=null && !addressOfIncorporation.prune().hasData()) addressOfIncorporation = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getIsInvestmentFirm()!=null) return true;
			if (getAddressOfBranch()!=null && getAddressOfBranch().hasData()) return true;
			if (getAddressOfIncorporation()!=null && getAddressOfIncorporation().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ExecutingEntity.ExecutingEntityBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ExecutingEntity.ExecutingEntityBuilder o = (ExecutingEntity.ExecutingEntityBuilder) other;
			
			merger.mergeRosetta(getAddressOfBranch(), o.getAddressOfBranch(), this::setAddressOfBranch);
			merger.mergeRosetta(getAddressOfIncorporation(), o.getAddressOfIncorporation(), this::setAddressOfIncorporation);
			
			merger.mergeBasic(getIsInvestmentFirm(), o.getIsInvestmentFirm(), this::setIsInvestmentFirm);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ExecutingEntity _that = getType().cast(o);
		
			if (!Objects.equals(isInvestmentFirm, _that.getIsInvestmentFirm())) return false;
			if (!Objects.equals(addressOfBranch, _that.getAddressOfBranch())) return false;
			if (!Objects.equals(addressOfIncorporation, _that.getAddressOfIncorporation())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (isInvestmentFirm != null ? isInvestmentFirm.hashCode() : 0);
			_result = 31 * _result + (addressOfBranch != null ? addressOfBranch.hashCode() : 0);
			_result = 31 * _result + (addressOfIncorporation != null ? addressOfIncorporation.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ExecutingEntityBuilder {" +
				"isInvestmentFirm=" + this.isInvestmentFirm + ", " +
				"addressOfBranch=" + this.addressOfBranch + ", " +
				"addressOfIncorporation=" + this.addressOfIncorporation +
			'}';
		}
	}
}
