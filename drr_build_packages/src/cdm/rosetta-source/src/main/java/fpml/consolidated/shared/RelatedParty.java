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
import fpml.consolidated.shared.meta.RelatedPartyMeta;
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
@RosettaDataType(value="RelatedParty", builder=RelatedParty.RelatedPartyBuilderImpl.class, version="2.1.1")
@RuneDataType(value="RelatedParty", model="fpml", builder=RelatedParty.RelatedPartyBuilderImpl.class, version="2.1.1")
public interface RelatedParty extends RosettaModelObject {

	RelatedPartyMeta metaData = new RelatedPartyMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Reference to a party.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Reference to a party.
	 *
	 */
	PartyReference getPartyReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Reference to an account.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Reference to an account.
	 *
	 */
	AccountReference getAccountReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The category of the relationship. The related party performs the role specified in this field for the base party. For example, if the role is "Guarantor", the related party acts as a guarantor for the base party.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The category of the relationship. The related party performs the role specified in this field for the base party. For example, if the role is "Guarantor", the related party acts as a guarantor for the base party.
	 *
	 */
	PartyRole getRole();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Additional definition refining the type of relationship. For example, if the "role" is Guarantor, this element may be used to specify whether all positions are guaranteed, or only a subset of them.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Additional definition refining the type of relationship. For example, if the "role" is Guarantor, this element may be used to specify whether all positions are guaranteed, or only a subset of them.
	 *
	 */
	PartyRoleType _getType();

	/*********************** Build Methods  ***********************/
	RelatedParty build();
	
	RelatedParty.RelatedPartyBuilder toBuilder();
	
	static RelatedParty.RelatedPartyBuilder builder() {
		return new RelatedParty.RelatedPartyBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends RelatedParty> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends RelatedParty> getType() {
		return RelatedParty.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("partyReference"), processor, PartyReference.class, getPartyReference());
		processRosetta(path.newSubPath("accountReference"), processor, AccountReference.class, getAccountReference());
		processRosetta(path.newSubPath("role"), processor, PartyRole.class, getRole());
		processRosetta(path.newSubPath("type"), processor, PartyRoleType.class, _getType());
	}
	

	/*********************** Builder Interface  ***********************/
	interface RelatedPartyBuilder extends RelatedParty, RosettaModelObjectBuilder {
		PartyReference.PartyReferenceBuilder getOrCreatePartyReference();
		@Override
		PartyReference.PartyReferenceBuilder getPartyReference();
		AccountReference.AccountReferenceBuilder getOrCreateAccountReference();
		@Override
		AccountReference.AccountReferenceBuilder getAccountReference();
		PartyRole.PartyRoleBuilder getOrCreateRole();
		@Override
		PartyRole.PartyRoleBuilder getRole();
		PartyRoleType.PartyRoleTypeBuilder getOrCreateType();
		@Override
		PartyRoleType.PartyRoleTypeBuilder _getType();
		RelatedParty.RelatedPartyBuilder setPartyReference(PartyReference partyReference);
		RelatedParty.RelatedPartyBuilder setAccountReference(AccountReference accountReference);
		RelatedParty.RelatedPartyBuilder setRole(PartyRole role);
		RelatedParty.RelatedPartyBuilder setType(PartyRoleType type);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("partyReference"), processor, PartyReference.PartyReferenceBuilder.class, getPartyReference());
			processRosetta(path.newSubPath("accountReference"), processor, AccountReference.AccountReferenceBuilder.class, getAccountReference());
			processRosetta(path.newSubPath("role"), processor, PartyRole.PartyRoleBuilder.class, getRole());
			processRosetta(path.newSubPath("type"), processor, PartyRoleType.PartyRoleTypeBuilder.class, _getType());
		}
		

		RelatedParty.RelatedPartyBuilder prune();
	}

	/*********************** Immutable Implementation of RelatedParty  ***********************/
	class RelatedPartyImpl implements RelatedParty {
		private final PartyReference partyReference;
		private final AccountReference accountReference;
		private final PartyRole role;
		private final PartyRoleType type;
		
		protected RelatedPartyImpl(RelatedParty.RelatedPartyBuilder builder) {
			this.partyReference = ofNullable(builder.getPartyReference()).map(f->f.build()).orElse(null);
			this.accountReference = ofNullable(builder.getAccountReference()).map(f->f.build()).orElse(null);
			this.role = ofNullable(builder.getRole()).map(f->f.build()).orElse(null);
			this.type = ofNullable(builder._getType()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("partyReference")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("partyReference")
		public PartyReference getPartyReference() {
			return partyReference;
		}
		
		@Override
		@RosettaAttribute("accountReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("accountReference")
		public AccountReference getAccountReference() {
			return accountReference;
		}
		
		@Override
		@RosettaAttribute("role")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("role")
		public PartyRole getRole() {
			return role;
		}
		
		@Override
		@RosettaAttribute("type")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("type")
		public PartyRoleType _getType() {
			return type;
		}
		
		@Override
		public RelatedParty build() {
			return this;
		}
		
		@Override
		public RelatedParty.RelatedPartyBuilder toBuilder() {
			RelatedParty.RelatedPartyBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(RelatedParty.RelatedPartyBuilder builder) {
			ofNullable(getPartyReference()).ifPresent(builder::setPartyReference);
			ofNullable(getAccountReference()).ifPresent(builder::setAccountReference);
			ofNullable(getRole()).ifPresent(builder::setRole);
			ofNullable(_getType()).ifPresent(builder::setType);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			RelatedParty _that = getType().cast(o);
		
			if (!Objects.equals(partyReference, _that.getPartyReference())) return false;
			if (!Objects.equals(accountReference, _that.getAccountReference())) return false;
			if (!Objects.equals(role, _that.getRole())) return false;
			if (!Objects.equals(type, _that._getType())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (partyReference != null ? partyReference.hashCode() : 0);
			_result = 31 * _result + (accountReference != null ? accountReference.hashCode() : 0);
			_result = 31 * _result + (role != null ? role.hashCode() : 0);
			_result = 31 * _result + (type != null ? type.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RelatedParty {" +
				"partyReference=" + this.partyReference + ", " +
				"accountReference=" + this.accountReference + ", " +
				"role=" + this.role + ", " +
				"type=" + this.type +
			'}';
		}
	}

	/*********************** Builder Implementation of RelatedParty  ***********************/
	class RelatedPartyBuilderImpl implements RelatedParty.RelatedPartyBuilder {
	
		protected PartyReference.PartyReferenceBuilder partyReference;
		protected AccountReference.AccountReferenceBuilder accountReference;
		protected PartyRole.PartyRoleBuilder role;
		protected PartyRoleType.PartyRoleTypeBuilder type;
		
		@Override
		@RosettaAttribute("partyReference")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("partyReference")
		public PartyReference.PartyReferenceBuilder getPartyReference() {
			return partyReference;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreatePartyReference() {
			PartyReference.PartyReferenceBuilder result;
			if (partyReference!=null) {
				result = partyReference;
			}
			else {
				result = partyReference = PartyReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("accountReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("accountReference")
		public AccountReference.AccountReferenceBuilder getAccountReference() {
			return accountReference;
		}
		
		@Override
		public AccountReference.AccountReferenceBuilder getOrCreateAccountReference() {
			AccountReference.AccountReferenceBuilder result;
			if (accountReference!=null) {
				result = accountReference;
			}
			else {
				result = accountReference = AccountReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("role")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("role")
		public PartyRole.PartyRoleBuilder getRole() {
			return role;
		}
		
		@Override
		public PartyRole.PartyRoleBuilder getOrCreateRole() {
			PartyRole.PartyRoleBuilder result;
			if (role!=null) {
				result = role;
			}
			else {
				result = role = PartyRole.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("type")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("type")
		public PartyRoleType.PartyRoleTypeBuilder _getType() {
			return type;
		}
		
		@Override
		public PartyRoleType.PartyRoleTypeBuilder getOrCreateType() {
			PartyRoleType.PartyRoleTypeBuilder result;
			if (type!=null) {
				result = type;
			}
			else {
				result = type = PartyRoleType.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("partyReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("partyReference")
		@Override
		public RelatedParty.RelatedPartyBuilder setPartyReference(PartyReference _partyReference) {
			this.partyReference = _partyReference == null ? null : _partyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("accountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("accountReference")
		@Override
		public RelatedParty.RelatedPartyBuilder setAccountReference(AccountReference _accountReference) {
			this.accountReference = _accountReference == null ? null : _accountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("role")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("role")
		@Override
		public RelatedParty.RelatedPartyBuilder setRole(PartyRole _role) {
			this.role = _role == null ? null : _role.toBuilder();
			return this;
		}
		
		@RosettaAttribute("type")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("type")
		@Override
		public RelatedParty.RelatedPartyBuilder setType(PartyRoleType _type) {
			this.type = _type == null ? null : _type.toBuilder();
			return this;
		}
		
		@Override
		public RelatedParty build() {
			return new RelatedParty.RelatedPartyImpl(this);
		}
		
		@Override
		public RelatedParty.RelatedPartyBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RelatedParty.RelatedPartyBuilder prune() {
			if (partyReference!=null && !partyReference.prune().hasData()) partyReference = null;
			if (accountReference!=null && !accountReference.prune().hasData()) accountReference = null;
			if (role!=null && !role.prune().hasData()) role = null;
			if (type!=null && !type.prune().hasData()) type = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPartyReference()!=null && getPartyReference().hasData()) return true;
			if (getAccountReference()!=null && getAccountReference().hasData()) return true;
			if (getRole()!=null && getRole().hasData()) return true;
			if (_getType()!=null && _getType().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RelatedParty.RelatedPartyBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			RelatedParty.RelatedPartyBuilder o = (RelatedParty.RelatedPartyBuilder) other;
			
			merger.mergeRosetta(getPartyReference(), o.getPartyReference(), this::setPartyReference);
			merger.mergeRosetta(getAccountReference(), o.getAccountReference(), this::setAccountReference);
			merger.mergeRosetta(getRole(), o.getRole(), this::setRole);
			merger.mergeRosetta(_getType(), o._getType(), this::setType);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			RelatedParty _that = getType().cast(o);
		
			if (!Objects.equals(partyReference, _that.getPartyReference())) return false;
			if (!Objects.equals(accountReference, _that.getAccountReference())) return false;
			if (!Objects.equals(role, _that.getRole())) return false;
			if (!Objects.equals(type, _that._getType())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (partyReference != null ? partyReference.hashCode() : 0);
			_result = 31 * _result + (accountReference != null ? accountReference.hashCode() : 0);
			_result = 31 * _result + (role != null ? role.hashCode() : 0);
			_result = 31 * _result + (type != null ? type.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RelatedPartyBuilder {" +
				"partyReference=" + this.partyReference + ", " +
				"accountReference=" + this.accountReference + ", " +
				"role=" + this.role + ", " +
				"type=" + this.type +
			'}';
		}
	}
}
