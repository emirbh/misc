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
import fpml.consolidated.shared.meta.RoutingIdsAndExplicitDetailsMeta;
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
 * Provision A type that provides a combination of payment system identification codes with physical postal address details, for the purposes of identifying a party involved in the routing of a payment.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type that provides a combination of payment system identification codes with physical postal address details, for the purposes of identifying a party involved in the routing of a payment.
 *
 */
@RosettaDataType(value="RoutingIdsAndExplicitDetails", builder=RoutingIdsAndExplicitDetails.RoutingIdsAndExplicitDetailsBuilderImpl.class, version="2.1.1")
@RuneDataType(value="RoutingIdsAndExplicitDetails", model="fpml", builder=RoutingIdsAndExplicitDetails.RoutingIdsAndExplicitDetailsBuilderImpl.class, version="2.1.1")
public interface RoutingIdsAndExplicitDetails extends RosettaModelObject {

	RoutingIdsAndExplicitDetailsMeta metaData = new RoutingIdsAndExplicitDetailsMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A set of unique identifiers for a party, eachone identifying the party within a payment system. The assumption is that each party will not have more than one identifier within the same payment system.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A set of unique identifiers for a party, eachone identifying the party within a payment system. The assumption is that each party will not have more than one identifier within the same payment system.
	 *
	 */
	List<? extends RoutingIds> getRoutingIds();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A real name that is used to identify a party involved in the routing of a payment.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A real name that is used to identify a party involved in the routing of a payment.
	 *
	 */
	String getRoutingName();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A physical postal address via which a payment can be routed.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A physical postal address via which a payment can be routed.
	 *
	 */
	Address getRoutingAddress();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision An account number via which a payment can be routed.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision An account number via which a payment can be routed.
	 *
	 */
	String getRoutingAccountNumber();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A piece of free-format text used to assist the identification of a party involved in the routing of a payment.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A piece of free-format text used to assist the identification of a party involved in the routing of a payment.
	 *
	 */
	List<String> getRoutingReferenceText();

	/*********************** Build Methods  ***********************/
	RoutingIdsAndExplicitDetails build();
	
	RoutingIdsAndExplicitDetails.RoutingIdsAndExplicitDetailsBuilder toBuilder();
	
	static RoutingIdsAndExplicitDetails.RoutingIdsAndExplicitDetailsBuilder builder() {
		return new RoutingIdsAndExplicitDetails.RoutingIdsAndExplicitDetailsBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends RoutingIdsAndExplicitDetails> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends RoutingIdsAndExplicitDetails> getType() {
		return RoutingIdsAndExplicitDetails.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("routingIds"), processor, RoutingIds.class, getRoutingIds());
		processor.processBasic(path.newSubPath("routingName"), String.class, getRoutingName(), this);
		processRosetta(path.newSubPath("routingAddress"), processor, Address.class, getRoutingAddress());
		processor.processBasic(path.newSubPath("routingAccountNumber"), String.class, getRoutingAccountNumber(), this);
		processor.processBasic(path.newSubPath("routingReferenceText"), String.class, getRoutingReferenceText(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface RoutingIdsAndExplicitDetailsBuilder extends RoutingIdsAndExplicitDetails, RosettaModelObjectBuilder {
		RoutingIds.RoutingIdsBuilder getOrCreateRoutingIds(int index);
		@Override
		List<? extends RoutingIds.RoutingIdsBuilder> getRoutingIds();
		Address.AddressBuilder getOrCreateRoutingAddress();
		@Override
		Address.AddressBuilder getRoutingAddress();
		RoutingIdsAndExplicitDetails.RoutingIdsAndExplicitDetailsBuilder addRoutingIds(RoutingIds routingIds);
		RoutingIdsAndExplicitDetails.RoutingIdsAndExplicitDetailsBuilder addRoutingIds(RoutingIds routingIds, int idx);
		RoutingIdsAndExplicitDetails.RoutingIdsAndExplicitDetailsBuilder addRoutingIds(List<? extends RoutingIds> routingIds);
		RoutingIdsAndExplicitDetails.RoutingIdsAndExplicitDetailsBuilder setRoutingIds(List<? extends RoutingIds> routingIds);
		RoutingIdsAndExplicitDetails.RoutingIdsAndExplicitDetailsBuilder setRoutingName(String routingName);
		RoutingIdsAndExplicitDetails.RoutingIdsAndExplicitDetailsBuilder setRoutingAddress(Address routingAddress);
		RoutingIdsAndExplicitDetails.RoutingIdsAndExplicitDetailsBuilder setRoutingAccountNumber(String routingAccountNumber);
		RoutingIdsAndExplicitDetails.RoutingIdsAndExplicitDetailsBuilder addRoutingReferenceText(String routingReferenceText);
		RoutingIdsAndExplicitDetails.RoutingIdsAndExplicitDetailsBuilder addRoutingReferenceText(String routingReferenceText, int idx);
		RoutingIdsAndExplicitDetails.RoutingIdsAndExplicitDetailsBuilder addRoutingReferenceText(List<String> routingReferenceText);
		RoutingIdsAndExplicitDetails.RoutingIdsAndExplicitDetailsBuilder setRoutingReferenceText(List<String> routingReferenceText);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("routingIds"), processor, RoutingIds.RoutingIdsBuilder.class, getRoutingIds());
			processor.processBasic(path.newSubPath("routingName"), String.class, getRoutingName(), this);
			processRosetta(path.newSubPath("routingAddress"), processor, Address.AddressBuilder.class, getRoutingAddress());
			processor.processBasic(path.newSubPath("routingAccountNumber"), String.class, getRoutingAccountNumber(), this);
			processor.processBasic(path.newSubPath("routingReferenceText"), String.class, getRoutingReferenceText(), this);
		}
		

		RoutingIdsAndExplicitDetails.RoutingIdsAndExplicitDetailsBuilder prune();
	}

	/*********************** Immutable Implementation of RoutingIdsAndExplicitDetails  ***********************/
	class RoutingIdsAndExplicitDetailsImpl implements RoutingIdsAndExplicitDetails {
		private final List<? extends RoutingIds> routingIds;
		private final String routingName;
		private final Address routingAddress;
		private final String routingAccountNumber;
		private final List<String> routingReferenceText;
		
		protected RoutingIdsAndExplicitDetailsImpl(RoutingIdsAndExplicitDetails.RoutingIdsAndExplicitDetailsBuilder builder) {
			this.routingIds = ofNullable(builder.getRoutingIds()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.routingName = builder.getRoutingName();
			this.routingAddress = ofNullable(builder.getRoutingAddress()).map(f->f.build()).orElse(null);
			this.routingAccountNumber = builder.getRoutingAccountNumber();
			this.routingReferenceText = ofNullable(builder.getRoutingReferenceText()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
		}
		
		@Override
		@RosettaAttribute("routingIds")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("routingIds")
		public List<? extends RoutingIds> getRoutingIds() {
			return routingIds;
		}
		
		@Override
		@RosettaAttribute("routingName")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("routingName")
		public String getRoutingName() {
			return routingName;
		}
		
		@Override
		@RosettaAttribute("routingAddress")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("routingAddress")
		public Address getRoutingAddress() {
			return routingAddress;
		}
		
		@Override
		@RosettaAttribute("routingAccountNumber")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("routingAccountNumber")
		public String getRoutingAccountNumber() {
			return routingAccountNumber;
		}
		
		@Override
		@RosettaAttribute("routingReferenceText")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("routingReferenceText")
		public List<String> getRoutingReferenceText() {
			return routingReferenceText;
		}
		
		@Override
		public RoutingIdsAndExplicitDetails build() {
			return this;
		}
		
		@Override
		public RoutingIdsAndExplicitDetails.RoutingIdsAndExplicitDetailsBuilder toBuilder() {
			RoutingIdsAndExplicitDetails.RoutingIdsAndExplicitDetailsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(RoutingIdsAndExplicitDetails.RoutingIdsAndExplicitDetailsBuilder builder) {
			ofNullable(getRoutingIds()).ifPresent(builder::setRoutingIds);
			ofNullable(getRoutingName()).ifPresent(builder::setRoutingName);
			ofNullable(getRoutingAddress()).ifPresent(builder::setRoutingAddress);
			ofNullable(getRoutingAccountNumber()).ifPresent(builder::setRoutingAccountNumber);
			ofNullable(getRoutingReferenceText()).ifPresent(builder::setRoutingReferenceText);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			RoutingIdsAndExplicitDetails _that = getType().cast(o);
		
			if (!ListEquals.listEquals(routingIds, _that.getRoutingIds())) return false;
			if (!Objects.equals(routingName, _that.getRoutingName())) return false;
			if (!Objects.equals(routingAddress, _that.getRoutingAddress())) return false;
			if (!Objects.equals(routingAccountNumber, _that.getRoutingAccountNumber())) return false;
			if (!ListEquals.listEquals(routingReferenceText, _that.getRoutingReferenceText())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (routingIds != null ? routingIds.hashCode() : 0);
			_result = 31 * _result + (routingName != null ? routingName.hashCode() : 0);
			_result = 31 * _result + (routingAddress != null ? routingAddress.hashCode() : 0);
			_result = 31 * _result + (routingAccountNumber != null ? routingAccountNumber.hashCode() : 0);
			_result = 31 * _result + (routingReferenceText != null ? routingReferenceText.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RoutingIdsAndExplicitDetails {" +
				"routingIds=" + this.routingIds + ", " +
				"routingName=" + this.routingName + ", " +
				"routingAddress=" + this.routingAddress + ", " +
				"routingAccountNumber=" + this.routingAccountNumber + ", " +
				"routingReferenceText=" + this.routingReferenceText +
			'}';
		}
	}

	/*********************** Builder Implementation of RoutingIdsAndExplicitDetails  ***********************/
	class RoutingIdsAndExplicitDetailsBuilderImpl implements RoutingIdsAndExplicitDetails.RoutingIdsAndExplicitDetailsBuilder {
	
		protected List<RoutingIds.RoutingIdsBuilder> routingIds = new ArrayList<>();
		protected String routingName;
		protected Address.AddressBuilder routingAddress;
		protected String routingAccountNumber;
		protected List<String> routingReferenceText = new ArrayList<>();
		
		@Override
		@RosettaAttribute("routingIds")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("routingIds")
		public List<? extends RoutingIds.RoutingIdsBuilder> getRoutingIds() {
			return routingIds;
		}
		
		@Override
		public RoutingIds.RoutingIdsBuilder getOrCreateRoutingIds(int index) {
			if (routingIds==null) {
				this.routingIds = new ArrayList<>();
			}
			return getIndex(routingIds, index, () -> {
						RoutingIds.RoutingIdsBuilder newRoutingIds = RoutingIds.builder();
						return newRoutingIds;
					});
		}
		
		@Override
		@RosettaAttribute("routingName")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("routingName")
		public String getRoutingName() {
			return routingName;
		}
		
		@Override
		@RosettaAttribute("routingAddress")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("routingAddress")
		public Address.AddressBuilder getRoutingAddress() {
			return routingAddress;
		}
		
		@Override
		public Address.AddressBuilder getOrCreateRoutingAddress() {
			Address.AddressBuilder result;
			if (routingAddress!=null) {
				result = routingAddress;
			}
			else {
				result = routingAddress = Address.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("routingAccountNumber")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("routingAccountNumber")
		public String getRoutingAccountNumber() {
			return routingAccountNumber;
		}
		
		@Override
		@RosettaAttribute("routingReferenceText")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("routingReferenceText")
		public List<String> getRoutingReferenceText() {
			return routingReferenceText;
		}
		
		@RosettaAttribute("routingIds")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("routingIds")
		@Override
		public RoutingIdsAndExplicitDetails.RoutingIdsAndExplicitDetailsBuilder addRoutingIds(RoutingIds _routingIds) {
			if (_routingIds != null) {
				this.routingIds.add(_routingIds.toBuilder());
			}
			return this;
		}
		
		@Override
		public RoutingIdsAndExplicitDetails.RoutingIdsAndExplicitDetailsBuilder addRoutingIds(RoutingIds _routingIds, int idx) {
			getIndex(this.routingIds, idx, () -> _routingIds.toBuilder());
			return this;
		}
		
		@Override
		public RoutingIdsAndExplicitDetails.RoutingIdsAndExplicitDetailsBuilder addRoutingIds(List<? extends RoutingIds> routingIdss) {
			if (routingIdss != null) {
				for (final RoutingIds toAdd : routingIdss) {
					this.routingIds.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("routingIds")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("routingIds")
		@Override
		public RoutingIdsAndExplicitDetails.RoutingIdsAndExplicitDetailsBuilder setRoutingIds(List<? extends RoutingIds> routingIdss) {
			if (routingIdss == null) {
				this.routingIds = new ArrayList<>();
			} else {
				this.routingIds = routingIdss.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("routingName")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("routingName")
		@Override
		public RoutingIdsAndExplicitDetails.RoutingIdsAndExplicitDetailsBuilder setRoutingName(String _routingName) {
			this.routingName = _routingName == null ? null : _routingName;
			return this;
		}
		
		@RosettaAttribute("routingAddress")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("routingAddress")
		@Override
		public RoutingIdsAndExplicitDetails.RoutingIdsAndExplicitDetailsBuilder setRoutingAddress(Address _routingAddress) {
			this.routingAddress = _routingAddress == null ? null : _routingAddress.toBuilder();
			return this;
		}
		
		@RosettaAttribute("routingAccountNumber")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("routingAccountNumber")
		@Override
		public RoutingIdsAndExplicitDetails.RoutingIdsAndExplicitDetailsBuilder setRoutingAccountNumber(String _routingAccountNumber) {
			this.routingAccountNumber = _routingAccountNumber == null ? null : _routingAccountNumber;
			return this;
		}
		
		@RosettaAttribute("routingReferenceText")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("routingReferenceText")
		@Override
		public RoutingIdsAndExplicitDetails.RoutingIdsAndExplicitDetailsBuilder addRoutingReferenceText(String _routingReferenceText) {
			if (_routingReferenceText != null) {
				this.routingReferenceText.add(_routingReferenceText);
			}
			return this;
		}
		
		@Override
		public RoutingIdsAndExplicitDetails.RoutingIdsAndExplicitDetailsBuilder addRoutingReferenceText(String _routingReferenceText, int idx) {
			getIndex(this.routingReferenceText, idx, () -> _routingReferenceText);
			return this;
		}
		
		@Override
		public RoutingIdsAndExplicitDetails.RoutingIdsAndExplicitDetailsBuilder addRoutingReferenceText(List<String> routingReferenceTexts) {
			if (routingReferenceTexts != null) {
				for (final String toAdd : routingReferenceTexts) {
					this.routingReferenceText.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("routingReferenceText")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("routingReferenceText")
		@Override
		public RoutingIdsAndExplicitDetails.RoutingIdsAndExplicitDetailsBuilder setRoutingReferenceText(List<String> routingReferenceTexts) {
			if (routingReferenceTexts == null) {
				this.routingReferenceText = new ArrayList<>();
			} else {
				this.routingReferenceText = routingReferenceTexts.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public RoutingIdsAndExplicitDetails build() {
			return new RoutingIdsAndExplicitDetails.RoutingIdsAndExplicitDetailsImpl(this);
		}
		
		@Override
		public RoutingIdsAndExplicitDetails.RoutingIdsAndExplicitDetailsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RoutingIdsAndExplicitDetails.RoutingIdsAndExplicitDetailsBuilder prune() {
			routingIds = routingIds.stream().filter(b->b!=null).<RoutingIds.RoutingIdsBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (routingAddress!=null && !routingAddress.prune().hasData()) routingAddress = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getRoutingIds()!=null && getRoutingIds().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getRoutingName()!=null) return true;
			if (getRoutingAddress()!=null && getRoutingAddress().hasData()) return true;
			if (getRoutingAccountNumber()!=null) return true;
			if (getRoutingReferenceText()!=null && !getRoutingReferenceText().isEmpty()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RoutingIdsAndExplicitDetails.RoutingIdsAndExplicitDetailsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			RoutingIdsAndExplicitDetails.RoutingIdsAndExplicitDetailsBuilder o = (RoutingIdsAndExplicitDetails.RoutingIdsAndExplicitDetailsBuilder) other;
			
			merger.mergeRosetta(getRoutingIds(), o.getRoutingIds(), this::getOrCreateRoutingIds);
			merger.mergeRosetta(getRoutingAddress(), o.getRoutingAddress(), this::setRoutingAddress);
			
			merger.mergeBasic(getRoutingName(), o.getRoutingName(), this::setRoutingName);
			merger.mergeBasic(getRoutingAccountNumber(), o.getRoutingAccountNumber(), this::setRoutingAccountNumber);
			merger.mergeBasic(getRoutingReferenceText(), o.getRoutingReferenceText(), (Consumer<String>) this::addRoutingReferenceText);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			RoutingIdsAndExplicitDetails _that = getType().cast(o);
		
			if (!ListEquals.listEquals(routingIds, _that.getRoutingIds())) return false;
			if (!Objects.equals(routingName, _that.getRoutingName())) return false;
			if (!Objects.equals(routingAddress, _that.getRoutingAddress())) return false;
			if (!Objects.equals(routingAccountNumber, _that.getRoutingAccountNumber())) return false;
			if (!ListEquals.listEquals(routingReferenceText, _that.getRoutingReferenceText())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (routingIds != null ? routingIds.hashCode() : 0);
			_result = 31 * _result + (routingName != null ? routingName.hashCode() : 0);
			_result = 31 * _result + (routingAddress != null ? routingAddress.hashCode() : 0);
			_result = 31 * _result + (routingAccountNumber != null ? routingAccountNumber.hashCode() : 0);
			_result = 31 * _result + (routingReferenceText != null ? routingReferenceText.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RoutingIdsAndExplicitDetailsBuilder {" +
				"routingIds=" + this.routingIds + ", " +
				"routingName=" + this.routingName + ", " +
				"routingAddress=" + this.routingAddress + ", " +
				"routingAccountNumber=" + this.routingAccountNumber + ", " +
				"routingReferenceText=" + this.routingReferenceText +
			'}';
		}
	}
}
