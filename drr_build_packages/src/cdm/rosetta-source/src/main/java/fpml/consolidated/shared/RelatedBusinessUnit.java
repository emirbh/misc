package fpml.consolidated.shared;

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
import fpml.consolidated.shared.meta.RelatedBusinessUnitMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision 
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision 
 *
 */
@RosettaDataType(value="RelatedBusinessUnit", builder=RelatedBusinessUnit.RelatedBusinessUnitBuilderImpl.class, version="2.1.1")
@RuneDataType(value="RelatedBusinessUnit", model="fpml", builder=RelatedBusinessUnit.RelatedBusinessUnitBuilderImpl.class, version="2.1.1")
public interface RelatedBusinessUnit extends RosettaModelObject {

	RelatedBusinessUnitMeta metaData = new RelatedBusinessUnitMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The unit that is related to this.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The unit that is related to this.
	 *
	 */
	BusinessUnitReference getBusinessUnitReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The category of the relationship. The related unit performs the role specified in this field for the base party. For example, if the role is "Trader", the related unit acts acts or acted as the base party's trading unit.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The category of the relationship. The related unit performs the role specified in this field for the base party. For example, if the role is "Trader", the related unit acts acts or acted as the base party's trading unit.
	 *
	 */
	BusinessUnitRole getRole();

	/*********************** Build Methods  ***********************/
	RelatedBusinessUnit build();
	
	RelatedBusinessUnit.RelatedBusinessUnitBuilder toBuilder();
	
	static RelatedBusinessUnit.RelatedBusinessUnitBuilder builder() {
		return new RelatedBusinessUnit.RelatedBusinessUnitBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends RelatedBusinessUnit> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends RelatedBusinessUnit> getType() {
		return RelatedBusinessUnit.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("businessUnitReference"), processor, BusinessUnitReference.class, getBusinessUnitReference());
		processRosetta(path.newSubPath("role"), processor, BusinessUnitRole.class, getRole());
	}
	

	/*********************** Builder Interface  ***********************/
	interface RelatedBusinessUnitBuilder extends RelatedBusinessUnit, RosettaModelObjectBuilder {
		BusinessUnitReference.BusinessUnitReferenceBuilder getOrCreateBusinessUnitReference();
		@Override
		BusinessUnitReference.BusinessUnitReferenceBuilder getBusinessUnitReference();
		BusinessUnitRole.BusinessUnitRoleBuilder getOrCreateRole();
		@Override
		BusinessUnitRole.BusinessUnitRoleBuilder getRole();
		RelatedBusinessUnit.RelatedBusinessUnitBuilder setBusinessUnitReference(BusinessUnitReference businessUnitReference);
		RelatedBusinessUnit.RelatedBusinessUnitBuilder setRole(BusinessUnitRole role);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("businessUnitReference"), processor, BusinessUnitReference.BusinessUnitReferenceBuilder.class, getBusinessUnitReference());
			processRosetta(path.newSubPath("role"), processor, BusinessUnitRole.BusinessUnitRoleBuilder.class, getRole());
		}
		

		RelatedBusinessUnit.RelatedBusinessUnitBuilder prune();
	}

	/*********************** Immutable Implementation of RelatedBusinessUnit  ***********************/
	class RelatedBusinessUnitImpl implements RelatedBusinessUnit {
		private final BusinessUnitReference businessUnitReference;
		private final BusinessUnitRole role;
		
		protected RelatedBusinessUnitImpl(RelatedBusinessUnit.RelatedBusinessUnitBuilder builder) {
			this.businessUnitReference = ofNullable(builder.getBusinessUnitReference()).map(f->f.build()).orElse(null);
			this.role = ofNullable(builder.getRole()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("businessUnitReference")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("businessUnitReference")
		public BusinessUnitReference getBusinessUnitReference() {
			return businessUnitReference;
		}
		
		@Override
		@RosettaAttribute("role")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("role")
		public BusinessUnitRole getRole() {
			return role;
		}
		
		@Override
		public RelatedBusinessUnit build() {
			return this;
		}
		
		@Override
		public RelatedBusinessUnit.RelatedBusinessUnitBuilder toBuilder() {
			RelatedBusinessUnit.RelatedBusinessUnitBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(RelatedBusinessUnit.RelatedBusinessUnitBuilder builder) {
			ofNullable(getBusinessUnitReference()).ifPresent(builder::setBusinessUnitReference);
			ofNullable(getRole()).ifPresent(builder::setRole);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			RelatedBusinessUnit _that = getType().cast(o);
		
			if (!Objects.equals(businessUnitReference, _that.getBusinessUnitReference())) return false;
			if (!Objects.equals(role, _that.getRole())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (businessUnitReference != null ? businessUnitReference.hashCode() : 0);
			_result = 31 * _result + (role != null ? role.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RelatedBusinessUnit {" +
				"businessUnitReference=" + this.businessUnitReference + ", " +
				"role=" + this.role +
			'}';
		}
	}

	/*********************** Builder Implementation of RelatedBusinessUnit  ***********************/
	class RelatedBusinessUnitBuilderImpl implements RelatedBusinessUnit.RelatedBusinessUnitBuilder {
	
		protected BusinessUnitReference.BusinessUnitReferenceBuilder businessUnitReference;
		protected BusinessUnitRole.BusinessUnitRoleBuilder role;
		
		@Override
		@RosettaAttribute("businessUnitReference")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("businessUnitReference")
		public BusinessUnitReference.BusinessUnitReferenceBuilder getBusinessUnitReference() {
			return businessUnitReference;
		}
		
		@Override
		public BusinessUnitReference.BusinessUnitReferenceBuilder getOrCreateBusinessUnitReference() {
			BusinessUnitReference.BusinessUnitReferenceBuilder result;
			if (businessUnitReference!=null) {
				result = businessUnitReference;
			}
			else {
				result = businessUnitReference = BusinessUnitReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("role")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("role")
		public BusinessUnitRole.BusinessUnitRoleBuilder getRole() {
			return role;
		}
		
		@Override
		public BusinessUnitRole.BusinessUnitRoleBuilder getOrCreateRole() {
			BusinessUnitRole.BusinessUnitRoleBuilder result;
			if (role!=null) {
				result = role;
			}
			else {
				result = role = BusinessUnitRole.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("businessUnitReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("businessUnitReference")
		@Override
		public RelatedBusinessUnit.RelatedBusinessUnitBuilder setBusinessUnitReference(BusinessUnitReference _businessUnitReference) {
			this.businessUnitReference = _businessUnitReference == null ? null : _businessUnitReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("role")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("role")
		@Override
		public RelatedBusinessUnit.RelatedBusinessUnitBuilder setRole(BusinessUnitRole _role) {
			this.role = _role == null ? null : _role.toBuilder();
			return this;
		}
		
		@Override
		public RelatedBusinessUnit build() {
			return new RelatedBusinessUnit.RelatedBusinessUnitImpl(this);
		}
		
		@Override
		public RelatedBusinessUnit.RelatedBusinessUnitBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RelatedBusinessUnit.RelatedBusinessUnitBuilder prune() {
			if (businessUnitReference!=null && !businessUnitReference.prune().hasData()) businessUnitReference = null;
			if (role!=null && !role.prune().hasData()) role = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getBusinessUnitReference()!=null && getBusinessUnitReference().hasData()) return true;
			if (getRole()!=null && getRole().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RelatedBusinessUnit.RelatedBusinessUnitBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			RelatedBusinessUnit.RelatedBusinessUnitBuilder o = (RelatedBusinessUnit.RelatedBusinessUnitBuilder) other;
			
			merger.mergeRosetta(getBusinessUnitReference(), o.getBusinessUnitReference(), this::setBusinessUnitReference);
			merger.mergeRosetta(getRole(), o.getRole(), this::setRole);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			RelatedBusinessUnit _that = getType().cast(o);
		
			if (!Objects.equals(businessUnitReference, _that.getBusinessUnitReference())) return false;
			if (!Objects.equals(role, _that.getRole())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (businessUnitReference != null ? businessUnitReference.hashCode() : 0);
			_result = 31 * _result + (role != null ? role.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RelatedBusinessUnitBuilder {" +
				"businessUnitReference=" + this.businessUnitReference + ", " +
				"role=" + this.role +
			'}';
		}
	}
}
