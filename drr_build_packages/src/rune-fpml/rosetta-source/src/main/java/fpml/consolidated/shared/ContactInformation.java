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
import fpml.consolidated.shared.meta.ContactInformationMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A type that represents how to contact an individual or organization.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type that represents how to contact an individual or organization.
 *
 */
@RosettaDataType(value="ContactInformation", builder=ContactInformation.ContactInformationBuilderImpl.class, version="2.1.1")
@RuneDataType(value="ContactInformation", model="fpml", builder=ContactInformation.ContactInformationBuilderImpl.class, version="2.1.1")
public interface ContactInformation extends RosettaModelObject {

	ContactInformationMeta metaData = new ContactInformationMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A telephonic contact.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A telephonic contact.
	 *
	 */
	List<? extends TelephoneNumber> getTelephone();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision An address on an electronic mail or messaging sysem .
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision An address on an electronic mail or messaging sysem .
	 *
	 */
	List<String> getEmail();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A postal or street address.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A postal or street address.
	 *
	 */
	Address getAddress();

	/*********************** Build Methods  ***********************/
	ContactInformation build();
	
	ContactInformation.ContactInformationBuilder toBuilder();
	
	static ContactInformation.ContactInformationBuilder builder() {
		return new ContactInformation.ContactInformationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ContactInformation> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ContactInformation> getType() {
		return ContactInformation.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("telephone"), processor, TelephoneNumber.class, getTelephone());
		processor.processBasic(path.newSubPath("email"), String.class, getEmail(), this);
		processRosetta(path.newSubPath("address"), processor, Address.class, getAddress());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ContactInformationBuilder extends ContactInformation, RosettaModelObjectBuilder {
		TelephoneNumber.TelephoneNumberBuilder getOrCreateTelephone(int index);
		@Override
		List<? extends TelephoneNumber.TelephoneNumberBuilder> getTelephone();
		Address.AddressBuilder getOrCreateAddress();
		@Override
		Address.AddressBuilder getAddress();
		ContactInformation.ContactInformationBuilder addTelephone(TelephoneNumber telephone);
		ContactInformation.ContactInformationBuilder addTelephone(TelephoneNumber telephone, int idx);
		ContactInformation.ContactInformationBuilder addTelephone(List<? extends TelephoneNumber> telephone);
		ContactInformation.ContactInformationBuilder setTelephone(List<? extends TelephoneNumber> telephone);
		ContactInformation.ContactInformationBuilder addEmail(String email);
		ContactInformation.ContactInformationBuilder addEmail(String email, int idx);
		ContactInformation.ContactInformationBuilder addEmail(List<String> email);
		ContactInformation.ContactInformationBuilder setEmail(List<String> email);
		ContactInformation.ContactInformationBuilder setAddress(Address address);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("telephone"), processor, TelephoneNumber.TelephoneNumberBuilder.class, getTelephone());
			processor.processBasic(path.newSubPath("email"), String.class, getEmail(), this);
			processRosetta(path.newSubPath("address"), processor, Address.AddressBuilder.class, getAddress());
		}
		

		ContactInformation.ContactInformationBuilder prune();
	}

	/*********************** Immutable Implementation of ContactInformation  ***********************/
	class ContactInformationImpl implements ContactInformation {
		private final List<? extends TelephoneNumber> telephone;
		private final List<String> email;
		private final Address address;
		
		protected ContactInformationImpl(ContactInformation.ContactInformationBuilder builder) {
			this.telephone = ofNullable(builder.getTelephone()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.email = ofNullable(builder.getEmail()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.address = ofNullable(builder.getAddress()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("telephone")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("telephone")
		public List<? extends TelephoneNumber> getTelephone() {
			return telephone;
		}
		
		@Override
		@RosettaAttribute("email")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("email")
		public List<String> getEmail() {
			return email;
		}
		
		@Override
		@RosettaAttribute("address")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("address")
		public Address getAddress() {
			return address;
		}
		
		@Override
		public ContactInformation build() {
			return this;
		}
		
		@Override
		public ContactInformation.ContactInformationBuilder toBuilder() {
			ContactInformation.ContactInformationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ContactInformation.ContactInformationBuilder builder) {
			ofNullable(getTelephone()).ifPresent(builder::setTelephone);
			ofNullable(getEmail()).ifPresent(builder::setEmail);
			ofNullable(getAddress()).ifPresent(builder::setAddress);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ContactInformation _that = getType().cast(o);
		
			if (!ListEquals.listEquals(telephone, _that.getTelephone())) return false;
			if (!ListEquals.listEquals(email, _that.getEmail())) return false;
			if (!Objects.equals(address, _that.getAddress())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (telephone != null ? telephone.hashCode() : 0);
			_result = 31 * _result + (email != null ? email.hashCode() : 0);
			_result = 31 * _result + (address != null ? address.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ContactInformation {" +
				"telephone=" + this.telephone + ", " +
				"email=" + this.email + ", " +
				"address=" + this.address +
			'}';
		}
	}

	/*********************** Builder Implementation of ContactInformation  ***********************/
	class ContactInformationBuilderImpl implements ContactInformation.ContactInformationBuilder {
	
		protected List<TelephoneNumber.TelephoneNumberBuilder> telephone = new ArrayList<>();
		protected List<String> email = new ArrayList<>();
		protected Address.AddressBuilder address;
		
		@Override
		@RosettaAttribute("telephone")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("telephone")
		public List<? extends TelephoneNumber.TelephoneNumberBuilder> getTelephone() {
			return telephone;
		}
		
		@Override
		public TelephoneNumber.TelephoneNumberBuilder getOrCreateTelephone(int index) {
			if (telephone==null) {
				this.telephone = new ArrayList<>();
			}
			return getIndex(telephone, index, () -> {
						TelephoneNumber.TelephoneNumberBuilder newTelephone = TelephoneNumber.builder();
						return newTelephone;
					});
		}
		
		@Override
		@RosettaAttribute("email")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("email")
		public List<String> getEmail() {
			return email;
		}
		
		@Override
		@RosettaAttribute("address")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("address")
		public Address.AddressBuilder getAddress() {
			return address;
		}
		
		@Override
		public Address.AddressBuilder getOrCreateAddress() {
			Address.AddressBuilder result;
			if (address!=null) {
				result = address;
			}
			else {
				result = address = Address.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("telephone")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("telephone")
		@Override
		public ContactInformation.ContactInformationBuilder addTelephone(TelephoneNumber _telephone) {
			if (_telephone != null) {
				this.telephone.add(_telephone.toBuilder());
			}
			return this;
		}
		
		@Override
		public ContactInformation.ContactInformationBuilder addTelephone(TelephoneNumber _telephone, int idx) {
			getIndex(this.telephone, idx, () -> _telephone.toBuilder());
			return this;
		}
		
		@Override
		public ContactInformation.ContactInformationBuilder addTelephone(List<? extends TelephoneNumber> telephones) {
			if (telephones != null) {
				for (final TelephoneNumber toAdd : telephones) {
					this.telephone.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("telephone")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("telephone")
		@Override
		public ContactInformation.ContactInformationBuilder setTelephone(List<? extends TelephoneNumber> telephones) {
			if (telephones == null) {
				this.telephone = new ArrayList<>();
			} else {
				this.telephone = telephones.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("email")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("email")
		@Override
		public ContactInformation.ContactInformationBuilder addEmail(String _email) {
			if (_email != null) {
				this.email.add(_email);
			}
			return this;
		}
		
		@Override
		public ContactInformation.ContactInformationBuilder addEmail(String _email, int idx) {
			getIndex(this.email, idx, () -> _email);
			return this;
		}
		
		@Override
		public ContactInformation.ContactInformationBuilder addEmail(List<String> emails) {
			if (emails != null) {
				for (final String toAdd : emails) {
					this.email.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("email")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("email")
		@Override
		public ContactInformation.ContactInformationBuilder setEmail(List<String> emails) {
			if (emails == null) {
				this.email = new ArrayList<>();
			} else {
				this.email = emails.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("address")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("address")
		@Override
		public ContactInformation.ContactInformationBuilder setAddress(Address _address) {
			this.address = _address == null ? null : _address.toBuilder();
			return this;
		}
		
		@Override
		public ContactInformation build() {
			return new ContactInformation.ContactInformationImpl(this);
		}
		
		@Override
		public ContactInformation.ContactInformationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ContactInformation.ContactInformationBuilder prune() {
			telephone = telephone.stream().filter(b->b!=null).<TelephoneNumber.TelephoneNumberBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (address!=null && !address.prune().hasData()) address = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getTelephone()!=null && getTelephone().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getEmail()!=null && !getEmail().isEmpty()) return true;
			if (getAddress()!=null && getAddress().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ContactInformation.ContactInformationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ContactInformation.ContactInformationBuilder o = (ContactInformation.ContactInformationBuilder) other;
			
			merger.mergeRosetta(getTelephone(), o.getTelephone(), this::getOrCreateTelephone);
			merger.mergeRosetta(getAddress(), o.getAddress(), this::setAddress);
			
			merger.mergeBasic(getEmail(), o.getEmail(), (Consumer<String>) this::addEmail);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ContactInformation _that = getType().cast(o);
		
			if (!ListEquals.listEquals(telephone, _that.getTelephone())) return false;
			if (!ListEquals.listEquals(email, _that.getEmail())) return false;
			if (!Objects.equals(address, _that.getAddress())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (telephone != null ? telephone.hashCode() : 0);
			_result = 31 * _result + (email != null ? email.hashCode() : 0);
			_result = 31 * _result + (address != null ? address.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ContactInformationBuilder {" +
				"telephone=" + this.telephone + ", " +
				"email=" + this.email + ", " +
				"address=" + this.address +
			'}';
		}
	}
}
