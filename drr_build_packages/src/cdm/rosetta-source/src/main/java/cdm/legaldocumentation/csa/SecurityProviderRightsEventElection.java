package cdm.legaldocumentation.csa;

import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.legaldocumentation.csa.meta.SecurityProviderRightsEventElectionMeta;
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
 * A class to specify party specific Secured Party Rights Event language.
 * @version 6.23.0
 */
@RosettaDataType(value="SecurityProviderRightsEventElection", builder=SecurityProviderRightsEventElection.SecurityProviderRightsEventElectionBuilderImpl.class, version="6.23.0")
@RuneDataType(value="SecurityProviderRightsEventElection", model="cdm", builder=SecurityProviderRightsEventElection.SecurityProviderRightsEventElectionBuilderImpl.class, version="6.23.0")
public interface SecurityProviderRightsEventElection extends RosettaModelObject {

	SecurityProviderRightsEventElectionMeta metaData = new SecurityProviderRightsEventElectionMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The elective party.
	 */
	CounterpartyRoleEnum getParty();
	/**
	 * If True, the Rights Event language applies for the specified Party.
	 */
	Boolean getRightsEvent();

	/*********************** Build Methods  ***********************/
	SecurityProviderRightsEventElection build();
	
	SecurityProviderRightsEventElection.SecurityProviderRightsEventElectionBuilder toBuilder();
	
	static SecurityProviderRightsEventElection.SecurityProviderRightsEventElectionBuilder builder() {
		return new SecurityProviderRightsEventElection.SecurityProviderRightsEventElectionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends SecurityProviderRightsEventElection> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends SecurityProviderRightsEventElection> getType() {
		return SecurityProviderRightsEventElection.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("party"), CounterpartyRoleEnum.class, getParty(), this);
		processor.processBasic(path.newSubPath("rightsEvent"), Boolean.class, getRightsEvent(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface SecurityProviderRightsEventElectionBuilder extends SecurityProviderRightsEventElection, RosettaModelObjectBuilder {
		SecurityProviderRightsEventElection.SecurityProviderRightsEventElectionBuilder setParty(CounterpartyRoleEnum party);
		SecurityProviderRightsEventElection.SecurityProviderRightsEventElectionBuilder setRightsEvent(Boolean rightsEvent);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("party"), CounterpartyRoleEnum.class, getParty(), this);
			processor.processBasic(path.newSubPath("rightsEvent"), Boolean.class, getRightsEvent(), this);
		}
		

		SecurityProviderRightsEventElection.SecurityProviderRightsEventElectionBuilder prune();
	}

	/*********************** Immutable Implementation of SecurityProviderRightsEventElection  ***********************/
	class SecurityProviderRightsEventElectionImpl implements SecurityProviderRightsEventElection {
		private final CounterpartyRoleEnum party;
		private final Boolean rightsEvent;
		
		protected SecurityProviderRightsEventElectionImpl(SecurityProviderRightsEventElection.SecurityProviderRightsEventElectionBuilder builder) {
			this.party = builder.getParty();
			this.rightsEvent = builder.getRightsEvent();
		}
		
		@Override
		@RosettaAttribute("party")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("party")
		public CounterpartyRoleEnum getParty() {
			return party;
		}
		
		@Override
		@RosettaAttribute("rightsEvent")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("rightsEvent")
		public Boolean getRightsEvent() {
			return rightsEvent;
		}
		
		@Override
		public SecurityProviderRightsEventElection build() {
			return this;
		}
		
		@Override
		public SecurityProviderRightsEventElection.SecurityProviderRightsEventElectionBuilder toBuilder() {
			SecurityProviderRightsEventElection.SecurityProviderRightsEventElectionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SecurityProviderRightsEventElection.SecurityProviderRightsEventElectionBuilder builder) {
			ofNullable(getParty()).ifPresent(builder::setParty);
			ofNullable(getRightsEvent()).ifPresent(builder::setRightsEvent);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SecurityProviderRightsEventElection _that = getType().cast(o);
		
			if (!Objects.equals(party, _that.getParty())) return false;
			if (!Objects.equals(rightsEvent, _that.getRightsEvent())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (party != null ? party.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (rightsEvent != null ? rightsEvent.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SecurityProviderRightsEventElection {" +
				"party=" + this.party + ", " +
				"rightsEvent=" + this.rightsEvent +
			'}';
		}
	}

	/*********************** Builder Implementation of SecurityProviderRightsEventElection  ***********************/
	class SecurityProviderRightsEventElectionBuilderImpl implements SecurityProviderRightsEventElection.SecurityProviderRightsEventElectionBuilder {
	
		protected CounterpartyRoleEnum party;
		protected Boolean rightsEvent;
		
		@Override
		@RosettaAttribute("party")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("party")
		public CounterpartyRoleEnum getParty() {
			return party;
		}
		
		@Override
		@RosettaAttribute("rightsEvent")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("rightsEvent")
		public Boolean getRightsEvent() {
			return rightsEvent;
		}
		
		@RosettaAttribute("party")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("party")
		@Override
		public SecurityProviderRightsEventElection.SecurityProviderRightsEventElectionBuilder setParty(CounterpartyRoleEnum _party) {
			this.party = _party == null ? null : _party;
			return this;
		}
		
		@RosettaAttribute("rightsEvent")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("rightsEvent")
		@Override
		public SecurityProviderRightsEventElection.SecurityProviderRightsEventElectionBuilder setRightsEvent(Boolean _rightsEvent) {
			this.rightsEvent = _rightsEvent == null ? null : _rightsEvent;
			return this;
		}
		
		@Override
		public SecurityProviderRightsEventElection build() {
			return new SecurityProviderRightsEventElection.SecurityProviderRightsEventElectionImpl(this);
		}
		
		@Override
		public SecurityProviderRightsEventElection.SecurityProviderRightsEventElectionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SecurityProviderRightsEventElection.SecurityProviderRightsEventElectionBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getParty()!=null) return true;
			if (getRightsEvent()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SecurityProviderRightsEventElection.SecurityProviderRightsEventElectionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			SecurityProviderRightsEventElection.SecurityProviderRightsEventElectionBuilder o = (SecurityProviderRightsEventElection.SecurityProviderRightsEventElectionBuilder) other;
			
			
			merger.mergeBasic(getParty(), o.getParty(), this::setParty);
			merger.mergeBasic(getRightsEvent(), o.getRightsEvent(), this::setRightsEvent);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SecurityProviderRightsEventElection _that = getType().cast(o);
		
			if (!Objects.equals(party, _that.getParty())) return false;
			if (!Objects.equals(rightsEvent, _that.getRightsEvent())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (party != null ? party.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (rightsEvent != null ? rightsEvent.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SecurityProviderRightsEventElectionBuilder {" +
				"party=" + this.party + ", " +
				"rightsEvent=" + this.rightsEvent +
			'}';
		}
	}
}
