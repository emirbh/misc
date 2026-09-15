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
import fpml.consolidated.shared.meta.RoutingExplicitDetailsMeta;
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
 * Provision A type that models name, address and supplementary textual information for the purposes of identifying a party involved in the routing of a payment.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type that models name, address and supplementary textual information for the purposes of identifying a party involved in the routing of a payment.
 *
 */
@RosettaDataType(value="RoutingExplicitDetails", builder=RoutingExplicitDetails.RoutingExplicitDetailsBuilderImpl.class, version="2.1.1")
@RuneDataType(value="RoutingExplicitDetails", model="fpml", builder=RoutingExplicitDetails.RoutingExplicitDetailsBuilderImpl.class, version="2.1.1")
public interface RoutingExplicitDetails extends RosettaModelObject {

	RoutingExplicitDetailsMeta metaData = new RoutingExplicitDetailsMeta();

	/*********************** Getter Methods  ***********************/
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
	RoutingExplicitDetails build();
	
	RoutingExplicitDetails.RoutingExplicitDetailsBuilder toBuilder();
	
	static RoutingExplicitDetails.RoutingExplicitDetailsBuilder builder() {
		return new RoutingExplicitDetails.RoutingExplicitDetailsBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends RoutingExplicitDetails> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends RoutingExplicitDetails> getType() {
		return RoutingExplicitDetails.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("routingName"), String.class, getRoutingName(), this);
		processRosetta(path.newSubPath("routingAddress"), processor, Address.class, getRoutingAddress());
		processor.processBasic(path.newSubPath("routingAccountNumber"), String.class, getRoutingAccountNumber(), this);
		processor.processBasic(path.newSubPath("routingReferenceText"), String.class, getRoutingReferenceText(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface RoutingExplicitDetailsBuilder extends RoutingExplicitDetails, RosettaModelObjectBuilder {
		Address.AddressBuilder getOrCreateRoutingAddress();
		@Override
		Address.AddressBuilder getRoutingAddress();
		RoutingExplicitDetails.RoutingExplicitDetailsBuilder setRoutingName(String routingName);
		RoutingExplicitDetails.RoutingExplicitDetailsBuilder setRoutingAddress(Address routingAddress);
		RoutingExplicitDetails.RoutingExplicitDetailsBuilder setRoutingAccountNumber(String routingAccountNumber);
		RoutingExplicitDetails.RoutingExplicitDetailsBuilder addRoutingReferenceText(String routingReferenceText);
		RoutingExplicitDetails.RoutingExplicitDetailsBuilder addRoutingReferenceText(String routingReferenceText, int idx);
		RoutingExplicitDetails.RoutingExplicitDetailsBuilder addRoutingReferenceText(List<String> routingReferenceText);
		RoutingExplicitDetails.RoutingExplicitDetailsBuilder setRoutingReferenceText(List<String> routingReferenceText);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("routingName"), String.class, getRoutingName(), this);
			processRosetta(path.newSubPath("routingAddress"), processor, Address.AddressBuilder.class, getRoutingAddress());
			processor.processBasic(path.newSubPath("routingAccountNumber"), String.class, getRoutingAccountNumber(), this);
			processor.processBasic(path.newSubPath("routingReferenceText"), String.class, getRoutingReferenceText(), this);
		}
		

		RoutingExplicitDetails.RoutingExplicitDetailsBuilder prune();
	}

	/*********************** Immutable Implementation of RoutingExplicitDetails  ***********************/
	class RoutingExplicitDetailsImpl implements RoutingExplicitDetails {
		private final String routingName;
		private final Address routingAddress;
		private final String routingAccountNumber;
		private final List<String> routingReferenceText;
		
		protected RoutingExplicitDetailsImpl(RoutingExplicitDetails.RoutingExplicitDetailsBuilder builder) {
			this.routingName = builder.getRoutingName();
			this.routingAddress = ofNullable(builder.getRoutingAddress()).map(f->f.build()).orElse(null);
			this.routingAccountNumber = builder.getRoutingAccountNumber();
			this.routingReferenceText = ofNullable(builder.getRoutingReferenceText()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
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
		public RoutingExplicitDetails build() {
			return this;
		}
		
		@Override
		public RoutingExplicitDetails.RoutingExplicitDetailsBuilder toBuilder() {
			RoutingExplicitDetails.RoutingExplicitDetailsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(RoutingExplicitDetails.RoutingExplicitDetailsBuilder builder) {
			ofNullable(getRoutingName()).ifPresent(builder::setRoutingName);
			ofNullable(getRoutingAddress()).ifPresent(builder::setRoutingAddress);
			ofNullable(getRoutingAccountNumber()).ifPresent(builder::setRoutingAccountNumber);
			ofNullable(getRoutingReferenceText()).ifPresent(builder::setRoutingReferenceText);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			RoutingExplicitDetails _that = getType().cast(o);
		
			if (!Objects.equals(routingName, _that.getRoutingName())) return false;
			if (!Objects.equals(routingAddress, _that.getRoutingAddress())) return false;
			if (!Objects.equals(routingAccountNumber, _that.getRoutingAccountNumber())) return false;
			if (!ListEquals.listEquals(routingReferenceText, _that.getRoutingReferenceText())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (routingName != null ? routingName.hashCode() : 0);
			_result = 31 * _result + (routingAddress != null ? routingAddress.hashCode() : 0);
			_result = 31 * _result + (routingAccountNumber != null ? routingAccountNumber.hashCode() : 0);
			_result = 31 * _result + (routingReferenceText != null ? routingReferenceText.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RoutingExplicitDetails {" +
				"routingName=" + this.routingName + ", " +
				"routingAddress=" + this.routingAddress + ", " +
				"routingAccountNumber=" + this.routingAccountNumber + ", " +
				"routingReferenceText=" + this.routingReferenceText +
			'}';
		}
	}

	/*********************** Builder Implementation of RoutingExplicitDetails  ***********************/
	class RoutingExplicitDetailsBuilderImpl implements RoutingExplicitDetails.RoutingExplicitDetailsBuilder {
	
		protected String routingName;
		protected Address.AddressBuilder routingAddress;
		protected String routingAccountNumber;
		protected List<String> routingReferenceText = new ArrayList<>();
		
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
		
		@RosettaAttribute("routingName")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("routingName")
		@Override
		public RoutingExplicitDetails.RoutingExplicitDetailsBuilder setRoutingName(String _routingName) {
			this.routingName = _routingName == null ? null : _routingName;
			return this;
		}
		
		@RosettaAttribute("routingAddress")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("routingAddress")
		@Override
		public RoutingExplicitDetails.RoutingExplicitDetailsBuilder setRoutingAddress(Address _routingAddress) {
			this.routingAddress = _routingAddress == null ? null : _routingAddress.toBuilder();
			return this;
		}
		
		@RosettaAttribute("routingAccountNumber")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("routingAccountNumber")
		@Override
		public RoutingExplicitDetails.RoutingExplicitDetailsBuilder setRoutingAccountNumber(String _routingAccountNumber) {
			this.routingAccountNumber = _routingAccountNumber == null ? null : _routingAccountNumber;
			return this;
		}
		
		@RosettaAttribute("routingReferenceText")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("routingReferenceText")
		@Override
		public RoutingExplicitDetails.RoutingExplicitDetailsBuilder addRoutingReferenceText(String _routingReferenceText) {
			if (_routingReferenceText != null) {
				this.routingReferenceText.add(_routingReferenceText);
			}
			return this;
		}
		
		@Override
		public RoutingExplicitDetails.RoutingExplicitDetailsBuilder addRoutingReferenceText(String _routingReferenceText, int idx) {
			getIndex(this.routingReferenceText, idx, () -> _routingReferenceText);
			return this;
		}
		
		@Override
		public RoutingExplicitDetails.RoutingExplicitDetailsBuilder addRoutingReferenceText(List<String> routingReferenceTexts) {
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
		public RoutingExplicitDetails.RoutingExplicitDetailsBuilder setRoutingReferenceText(List<String> routingReferenceTexts) {
			if (routingReferenceTexts == null) {
				this.routingReferenceText = new ArrayList<>();
			} else {
				this.routingReferenceText = routingReferenceTexts.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public RoutingExplicitDetails build() {
			return new RoutingExplicitDetails.RoutingExplicitDetailsImpl(this);
		}
		
		@Override
		public RoutingExplicitDetails.RoutingExplicitDetailsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RoutingExplicitDetails.RoutingExplicitDetailsBuilder prune() {
			if (routingAddress!=null && !routingAddress.prune().hasData()) routingAddress = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getRoutingName()!=null) return true;
			if (getRoutingAddress()!=null && getRoutingAddress().hasData()) return true;
			if (getRoutingAccountNumber()!=null) return true;
			if (getRoutingReferenceText()!=null && !getRoutingReferenceText().isEmpty()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RoutingExplicitDetails.RoutingExplicitDetailsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			RoutingExplicitDetails.RoutingExplicitDetailsBuilder o = (RoutingExplicitDetails.RoutingExplicitDetailsBuilder) other;
			
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
		
			RoutingExplicitDetails _that = getType().cast(o);
		
			if (!Objects.equals(routingName, _that.getRoutingName())) return false;
			if (!Objects.equals(routingAddress, _that.getRoutingAddress())) return false;
			if (!Objects.equals(routingAccountNumber, _that.getRoutingAccountNumber())) return false;
			if (!ListEquals.listEquals(routingReferenceText, _that.getRoutingReferenceText())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (routingName != null ? routingName.hashCode() : 0);
			_result = 31 * _result + (routingAddress != null ? routingAddress.hashCode() : 0);
			_result = 31 * _result + (routingAccountNumber != null ? routingAccountNumber.hashCode() : 0);
			_result = 31 * _result + (routingReferenceText != null ? routingReferenceText.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RoutingExplicitDetailsBuilder {" +
				"routingName=" + this.routingName + ", " +
				"routingAddress=" + this.routingAddress + ", " +
				"routingAccountNumber=" + this.routingAccountNumber + ", " +
				"routingReferenceText=" + this.routingReferenceText +
			'}';
		}
	}
}
