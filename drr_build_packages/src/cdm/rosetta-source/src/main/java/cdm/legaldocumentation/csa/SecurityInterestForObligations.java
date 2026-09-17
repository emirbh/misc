package cdm.legaldocumentation.csa;

import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.legaldocumentation.csa.meta.SecurityInterestForObligationsMeta;
import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.Multi;
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
import com.rosetta.util.ListEquals;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * Security Interest for Obligations clause applicable to 1994 NY CSA, 1995 English Law CSA, 1995 English Law Credit Support Deed, 2016 English Law VM CSA and 2016 New York Law VM CSA.
 * @version 6.23.0
 *
 * Body ISDA
 * Corpus Annex CSA_NewYork_1994 1994 New York Law Credit Support Annex  
 * name "Security Interest for Obligations"
 *
 * Provision 
 *
 *
 * Body ISDA
 * Corpus Annex CSA_English_1995 1995 English Law Credit Support Annex  
 * name "Security Interest for Obligations"
 *
 * Provision 
 *
 *
 * Body ISDA
 * Corpus Deed CSD_English_1995 1995 English Law Credit Support Deed  
 * name "Security Interest for Obligations"
 *
 * Provision 
 *
 *
 * Body ISDA
 * Corpus Annex CSA_VM_English_2016 2016 English Law Variation Margin Credit Support Annex  
 * name "Security Interest for Obligations"
 *
 * Provision 
 *
 *
 * Body ISDA
 * Corpus Annex CSA_VM_NewYork_2016 2016 New York Law Variation Margin Credit Support Annex  
 * name "Security Interest for Obligations"
 *
 * Provision 
 *
 */
@RosettaDataType(value="SecurityInterestForObligations", builder=SecurityInterestForObligations.SecurityInterestForObligationsBuilderImpl.class, version="6.23.0")
@RuneDataType(value="SecurityInterestForObligations", model="cdm", builder=SecurityInterestForObligations.SecurityInterestForObligationsBuilderImpl.class, version="6.23.0")
public interface SecurityInterestForObligations extends RosettaModelObject {

	SecurityInterestForObligationsMeta metaData = new SecurityInterestForObligationsMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The elective party to which the Security Interest for Obligations is applicable.
	 */
	List<CounterpartyRoleEnum> getParty();
	/**
	 * A description of any additional obligations secured by the credit support arrangements.
	 */
	SecurityInterestObligationsEnum getObligations();
	/**
	 * The party to whom obligations under the Master Agreement are owed and secured by the credit support arrangements.
	 */
	SecurityInterestObligeeEnum getObligee();
	/**
	 * Exception value.
	 */
	String getOther();

	/*********************** Build Methods  ***********************/
	SecurityInterestForObligations build();
	
	SecurityInterestForObligations.SecurityInterestForObligationsBuilder toBuilder();
	
	static SecurityInterestForObligations.SecurityInterestForObligationsBuilder builder() {
		return new SecurityInterestForObligations.SecurityInterestForObligationsBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends SecurityInterestForObligations> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends SecurityInterestForObligations> getType() {
		return SecurityInterestForObligations.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("party"), CounterpartyRoleEnum.class, getParty(), this);
		processor.processBasic(path.newSubPath("obligations"), SecurityInterestObligationsEnum.class, getObligations(), this);
		processor.processBasic(path.newSubPath("obligee"), SecurityInterestObligeeEnum.class, getObligee(), this);
		processor.processBasic(path.newSubPath("other"), String.class, getOther(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface SecurityInterestForObligationsBuilder extends SecurityInterestForObligations, RosettaModelObjectBuilder {
		SecurityInterestForObligations.SecurityInterestForObligationsBuilder addParty(CounterpartyRoleEnum party);
		SecurityInterestForObligations.SecurityInterestForObligationsBuilder addParty(CounterpartyRoleEnum party, int idx);
		SecurityInterestForObligations.SecurityInterestForObligationsBuilder addParty(List<CounterpartyRoleEnum> party);
		SecurityInterestForObligations.SecurityInterestForObligationsBuilder setParty(List<CounterpartyRoleEnum> party);
		SecurityInterestForObligations.SecurityInterestForObligationsBuilder setObligations(SecurityInterestObligationsEnum obligations);
		SecurityInterestForObligations.SecurityInterestForObligationsBuilder setObligee(SecurityInterestObligeeEnum obligee);
		SecurityInterestForObligations.SecurityInterestForObligationsBuilder setOther(String other);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("party"), CounterpartyRoleEnum.class, getParty(), this);
			processor.processBasic(path.newSubPath("obligations"), SecurityInterestObligationsEnum.class, getObligations(), this);
			processor.processBasic(path.newSubPath("obligee"), SecurityInterestObligeeEnum.class, getObligee(), this);
			processor.processBasic(path.newSubPath("other"), String.class, getOther(), this);
		}
		

		SecurityInterestForObligations.SecurityInterestForObligationsBuilder prune();
	}

	/*********************** Immutable Implementation of SecurityInterestForObligations  ***********************/
	class SecurityInterestForObligationsImpl implements SecurityInterestForObligations {
		private final List<CounterpartyRoleEnum> party;
		private final SecurityInterestObligationsEnum obligations;
		private final SecurityInterestObligeeEnum obligee;
		private final String other;
		
		protected SecurityInterestForObligationsImpl(SecurityInterestForObligations.SecurityInterestForObligationsBuilder builder) {
			this.party = ofNullable(builder.getParty()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.obligations = builder.getObligations();
			this.obligee = builder.getObligee();
			this.other = builder.getOther();
		}
		
		@Override
		@RosettaAttribute("party")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("party")
		public List<CounterpartyRoleEnum> getParty() {
			return party;
		}
		
		@Override
		@RosettaAttribute("obligations")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("obligations")
		public SecurityInterestObligationsEnum getObligations() {
			return obligations;
		}
		
		@Override
		@RosettaAttribute("obligee")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("obligee")
		public SecurityInterestObligeeEnum getObligee() {
			return obligee;
		}
		
		@Override
		@RosettaAttribute("other")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("other")
		public String getOther() {
			return other;
		}
		
		@Override
		public SecurityInterestForObligations build() {
			return this;
		}
		
		@Override
		public SecurityInterestForObligations.SecurityInterestForObligationsBuilder toBuilder() {
			SecurityInterestForObligations.SecurityInterestForObligationsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SecurityInterestForObligations.SecurityInterestForObligationsBuilder builder) {
			ofNullable(getParty()).ifPresent(builder::setParty);
			ofNullable(getObligations()).ifPresent(builder::setObligations);
			ofNullable(getObligee()).ifPresent(builder::setObligee);
			ofNullable(getOther()).ifPresent(builder::setOther);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SecurityInterestForObligations _that = getType().cast(o);
		
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			if (!Objects.equals(obligations, _that.getObligations())) return false;
			if (!Objects.equals(obligee, _that.getObligee())) return false;
			if (!Objects.equals(other, _that.getOther())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (party != null ? party.stream().map(Object::getClass).map(Class::getName).mapToInt(String::hashCode).sum() : 0);
			_result = 31 * _result + (obligations != null ? obligations.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (obligee != null ? obligee.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (other != null ? other.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SecurityInterestForObligations {" +
				"party=" + this.party + ", " +
				"obligations=" + this.obligations + ", " +
				"obligee=" + this.obligee + ", " +
				"other=" + this.other +
			'}';
		}
	}

	/*********************** Builder Implementation of SecurityInterestForObligations  ***********************/
	class SecurityInterestForObligationsBuilderImpl implements SecurityInterestForObligations.SecurityInterestForObligationsBuilder {
	
		protected List<CounterpartyRoleEnum> party = new ArrayList<>();
		protected SecurityInterestObligationsEnum obligations;
		protected SecurityInterestObligeeEnum obligee;
		protected String other;
		
		@Override
		@RosettaAttribute("party")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("party")
		public List<CounterpartyRoleEnum> getParty() {
			return party;
		}
		
		@Override
		@RosettaAttribute("obligations")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("obligations")
		public SecurityInterestObligationsEnum getObligations() {
			return obligations;
		}
		
		@Override
		@RosettaAttribute("obligee")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("obligee")
		public SecurityInterestObligeeEnum getObligee() {
			return obligee;
		}
		
		@Override
		@RosettaAttribute("other")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("other")
		public String getOther() {
			return other;
		}
		
		@RosettaAttribute("party")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("party")
		@Override
		public SecurityInterestForObligations.SecurityInterestForObligationsBuilder addParty(CounterpartyRoleEnum _party) {
			if (_party != null) {
				this.party.add(_party);
			}
			return this;
		}
		
		@Override
		public SecurityInterestForObligations.SecurityInterestForObligationsBuilder addParty(CounterpartyRoleEnum _party, int idx) {
			getIndex(this.party, idx, () -> _party);
			return this;
		}
		
		@Override
		public SecurityInterestForObligations.SecurityInterestForObligationsBuilder addParty(List<CounterpartyRoleEnum> partys) {
			if (partys != null) {
				for (final CounterpartyRoleEnum toAdd : partys) {
					this.party.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("party")
		@Accessor(AccessorType.SETTER)
		@Required
		@Multi
		@RuneAttribute("party")
		@Override
		public SecurityInterestForObligations.SecurityInterestForObligationsBuilder setParty(List<CounterpartyRoleEnum> partys) {
			if (partys == null) {
				this.party = new ArrayList<>();
			} else {
				this.party = partys.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("obligations")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("obligations")
		@Override
		public SecurityInterestForObligations.SecurityInterestForObligationsBuilder setObligations(SecurityInterestObligationsEnum _obligations) {
			this.obligations = _obligations == null ? null : _obligations;
			return this;
		}
		
		@RosettaAttribute("obligee")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("obligee")
		@Override
		public SecurityInterestForObligations.SecurityInterestForObligationsBuilder setObligee(SecurityInterestObligeeEnum _obligee) {
			this.obligee = _obligee == null ? null : _obligee;
			return this;
		}
		
		@RosettaAttribute("other")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("other")
		@Override
		public SecurityInterestForObligations.SecurityInterestForObligationsBuilder setOther(String _other) {
			this.other = _other == null ? null : _other;
			return this;
		}
		
		@Override
		public SecurityInterestForObligations build() {
			return new SecurityInterestForObligations.SecurityInterestForObligationsImpl(this);
		}
		
		@Override
		public SecurityInterestForObligations.SecurityInterestForObligationsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SecurityInterestForObligations.SecurityInterestForObligationsBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getParty()!=null && !getParty().isEmpty()) return true;
			if (getObligations()!=null) return true;
			if (getObligee()!=null) return true;
			if (getOther()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SecurityInterestForObligations.SecurityInterestForObligationsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			SecurityInterestForObligations.SecurityInterestForObligationsBuilder o = (SecurityInterestForObligations.SecurityInterestForObligationsBuilder) other;
			
			
			merger.mergeBasic(getParty(), o.getParty(), (Consumer<CounterpartyRoleEnum>) this::addParty);
			merger.mergeBasic(getObligations(), o.getObligations(), this::setObligations);
			merger.mergeBasic(getObligee(), o.getObligee(), this::setObligee);
			merger.mergeBasic(getOther(), o.getOther(), this::setOther);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SecurityInterestForObligations _that = getType().cast(o);
		
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			if (!Objects.equals(obligations, _that.getObligations())) return false;
			if (!Objects.equals(obligee, _that.getObligee())) return false;
			if (!Objects.equals(other, _that.getOther())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (party != null ? party.stream().map(Object::getClass).map(Class::getName).mapToInt(String::hashCode).sum() : 0);
			_result = 31 * _result + (obligations != null ? obligations.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (obligee != null ? obligee.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (other != null ? other.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SecurityInterestForObligationsBuilder {" +
				"party=" + this.party + ", " +
				"obligations=" + this.obligations + ", " +
				"obligee=" + this.obligee + ", " +
				"other=" + this.other +
			'}';
		}
	}
}
