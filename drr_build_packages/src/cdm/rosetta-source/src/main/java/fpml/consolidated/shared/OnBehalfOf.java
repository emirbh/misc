package fpml.consolidated.shared;

import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.Multi;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.util.ListEquals;
import fpml.consolidated.shared.meta.OnBehalfOfMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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
@RosettaDataType(value="OnBehalfOf", builder=OnBehalfOf.OnBehalfOfBuilderImpl.class, version="2.1.1")
@RuneDataType(value="OnBehalfOf", model="fpml", builder=OnBehalfOf.OnBehalfOfBuilderImpl.class, version="2.1.1")
public interface OnBehalfOf extends RosettaModelObject {

	OnBehalfOfMeta metaData = new OnBehalfOfMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The party for which the message reciever should work.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The party for which the message reciever should work.
	 *
	 */
	PartyReference getPartyReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Identifies the account(s) related to the party when they cannot be determined from the party alone, for example in a inter-book trade.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Identifies the account(s) related to the party when they cannot be determined from the party alone, for example in a inter-book trade.
	 *
	 */
	List<? extends AccountReference> getAccountReference();

	/*********************** Build Methods  ***********************/
	OnBehalfOf build();
	
	OnBehalfOf.OnBehalfOfBuilder toBuilder();
	
	static OnBehalfOf.OnBehalfOfBuilder builder() {
		return new OnBehalfOf.OnBehalfOfBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends OnBehalfOf> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends OnBehalfOf> getType() {
		return OnBehalfOf.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("partyReference"), processor, PartyReference.class, getPartyReference());
		processRosetta(path.newSubPath("accountReference"), processor, AccountReference.class, getAccountReference());
	}
	

	/*********************** Builder Interface  ***********************/
	interface OnBehalfOfBuilder extends OnBehalfOf, RosettaModelObjectBuilder {
		PartyReference.PartyReferenceBuilder getOrCreatePartyReference();
		@Override
		PartyReference.PartyReferenceBuilder getPartyReference();
		AccountReference.AccountReferenceBuilder getOrCreateAccountReference(int index);
		@Override
		List<? extends AccountReference.AccountReferenceBuilder> getAccountReference();
		OnBehalfOf.OnBehalfOfBuilder setPartyReference(PartyReference partyReference);
		OnBehalfOf.OnBehalfOfBuilder addAccountReference(AccountReference accountReference);
		OnBehalfOf.OnBehalfOfBuilder addAccountReference(AccountReference accountReference, int idx);
		OnBehalfOf.OnBehalfOfBuilder addAccountReference(List<? extends AccountReference> accountReference);
		OnBehalfOf.OnBehalfOfBuilder setAccountReference(List<? extends AccountReference> accountReference);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("partyReference"), processor, PartyReference.PartyReferenceBuilder.class, getPartyReference());
			processRosetta(path.newSubPath("accountReference"), processor, AccountReference.AccountReferenceBuilder.class, getAccountReference());
		}
		

		OnBehalfOf.OnBehalfOfBuilder prune();
	}

	/*********************** Immutable Implementation of OnBehalfOf  ***********************/
	class OnBehalfOfImpl implements OnBehalfOf {
		private final PartyReference partyReference;
		private final List<? extends AccountReference> accountReference;
		
		protected OnBehalfOfImpl(OnBehalfOf.OnBehalfOfBuilder builder) {
			this.partyReference = ofNullable(builder.getPartyReference()).map(f->f.build()).orElse(null);
			this.accountReference = ofNullable(builder.getAccountReference()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("partyReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("partyReference")
		public PartyReference getPartyReference() {
			return partyReference;
		}
		
		@Override
		@RosettaAttribute("accountReference")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("accountReference")
		public List<? extends AccountReference> getAccountReference() {
			return accountReference;
		}
		
		@Override
		public OnBehalfOf build() {
			return this;
		}
		
		@Override
		public OnBehalfOf.OnBehalfOfBuilder toBuilder() {
			OnBehalfOf.OnBehalfOfBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(OnBehalfOf.OnBehalfOfBuilder builder) {
			ofNullable(getPartyReference()).ifPresent(builder::setPartyReference);
			ofNullable(getAccountReference()).ifPresent(builder::setAccountReference);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OnBehalfOf _that = getType().cast(o);
		
			if (!Objects.equals(partyReference, _that.getPartyReference())) return false;
			if (!ListEquals.listEquals(accountReference, _that.getAccountReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (partyReference != null ? partyReference.hashCode() : 0);
			_result = 31 * _result + (accountReference != null ? accountReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OnBehalfOf {" +
				"partyReference=" + this.partyReference + ", " +
				"accountReference=" + this.accountReference +
			'}';
		}
	}

	/*********************** Builder Implementation of OnBehalfOf  ***********************/
	class OnBehalfOfBuilderImpl implements OnBehalfOf.OnBehalfOfBuilder {
	
		protected PartyReference.PartyReferenceBuilder partyReference;
		protected List<AccountReference.AccountReferenceBuilder> accountReference = new ArrayList<>();
		
		@Override
		@RosettaAttribute("partyReference")
		@Accessor(AccessorType.GETTER)
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
		@Multi
		@RuneAttribute("accountReference")
		public List<? extends AccountReference.AccountReferenceBuilder> getAccountReference() {
			return accountReference;
		}
		
		@Override
		public AccountReference.AccountReferenceBuilder getOrCreateAccountReference(int index) {
			if (accountReference==null) {
				this.accountReference = new ArrayList<>();
			}
			return getIndex(accountReference, index, () -> {
						AccountReference.AccountReferenceBuilder newAccountReference = AccountReference.builder();
						return newAccountReference;
					});
		}
		
		@RosettaAttribute("partyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("partyReference")
		@Override
		public OnBehalfOf.OnBehalfOfBuilder setPartyReference(PartyReference _partyReference) {
			this.partyReference = _partyReference == null ? null : _partyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("accountReference")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("accountReference")
		@Override
		public OnBehalfOf.OnBehalfOfBuilder addAccountReference(AccountReference _accountReference) {
			if (_accountReference != null) {
				this.accountReference.add(_accountReference.toBuilder());
			}
			return this;
		}
		
		@Override
		public OnBehalfOf.OnBehalfOfBuilder addAccountReference(AccountReference _accountReference, int idx) {
			getIndex(this.accountReference, idx, () -> _accountReference.toBuilder());
			return this;
		}
		
		@Override
		public OnBehalfOf.OnBehalfOfBuilder addAccountReference(List<? extends AccountReference> accountReferences) {
			if (accountReferences != null) {
				for (final AccountReference toAdd : accountReferences) {
					this.accountReference.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("accountReference")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("accountReference")
		@Override
		public OnBehalfOf.OnBehalfOfBuilder setAccountReference(List<? extends AccountReference> accountReferences) {
			if (accountReferences == null) {
				this.accountReference = new ArrayList<>();
			} else {
				this.accountReference = accountReferences.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public OnBehalfOf build() {
			return new OnBehalfOf.OnBehalfOfImpl(this);
		}
		
		@Override
		public OnBehalfOf.OnBehalfOfBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OnBehalfOf.OnBehalfOfBuilder prune() {
			if (partyReference!=null && !partyReference.prune().hasData()) partyReference = null;
			accountReference = accountReference.stream().filter(b->b!=null).<AccountReference.AccountReferenceBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPartyReference()!=null && getPartyReference().hasData()) return true;
			if (getAccountReference()!=null && getAccountReference().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OnBehalfOf.OnBehalfOfBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			OnBehalfOf.OnBehalfOfBuilder o = (OnBehalfOf.OnBehalfOfBuilder) other;
			
			merger.mergeRosetta(getPartyReference(), o.getPartyReference(), this::setPartyReference);
			merger.mergeRosetta(getAccountReference(), o.getAccountReference(), this::getOrCreateAccountReference);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OnBehalfOf _that = getType().cast(o);
		
			if (!Objects.equals(partyReference, _that.getPartyReference())) return false;
			if (!ListEquals.listEquals(accountReference, _that.getAccountReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (partyReference != null ? partyReference.hashCode() : 0);
			_result = 31 * _result + (accountReference != null ? accountReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OnBehalfOfBuilder {" +
				"partyReference=" + this.partyReference + ", " +
				"accountReference=" + this.accountReference +
			'}';
		}
	}
}
