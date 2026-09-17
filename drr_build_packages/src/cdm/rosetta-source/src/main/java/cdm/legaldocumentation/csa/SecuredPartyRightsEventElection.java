package cdm.legaldocumentation.csa;

import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.legaldocumentation.csa.meta.SecuredPartyRightsEventElectionMeta;
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
@RosettaDataType(value="SecuredPartyRightsEventElection", builder=SecuredPartyRightsEventElection.SecuredPartyRightsEventElectionBuilderImpl.class, version="6.23.0")
@RuneDataType(value="SecuredPartyRightsEventElection", model="cdm", builder=SecuredPartyRightsEventElection.SecuredPartyRightsEventElectionBuilderImpl.class, version="6.23.0")
public interface SecuredPartyRightsEventElection extends RosettaModelObject {

	SecuredPartyRightsEventElectionMeta metaData = new SecuredPartyRightsEventElectionMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The elective party.
	 */
	CounterpartyRoleEnum getParty();
	/**
	 * A boolean attribute to specify whether a Secured Party Rights Event will only occur upon the occurrence of one or more of the event specified in a Control Agreement.
	 */
	Boolean getRightsEvent();

	/*********************** Build Methods  ***********************/
	SecuredPartyRightsEventElection build();
	
	SecuredPartyRightsEventElection.SecuredPartyRightsEventElectionBuilder toBuilder();
	
	static SecuredPartyRightsEventElection.SecuredPartyRightsEventElectionBuilder builder() {
		return new SecuredPartyRightsEventElection.SecuredPartyRightsEventElectionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends SecuredPartyRightsEventElection> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends SecuredPartyRightsEventElection> getType() {
		return SecuredPartyRightsEventElection.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("party"), CounterpartyRoleEnum.class, getParty(), this);
		processor.processBasic(path.newSubPath("rightsEvent"), Boolean.class, getRightsEvent(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface SecuredPartyRightsEventElectionBuilder extends SecuredPartyRightsEventElection, RosettaModelObjectBuilder {
		SecuredPartyRightsEventElection.SecuredPartyRightsEventElectionBuilder setParty(CounterpartyRoleEnum party);
		SecuredPartyRightsEventElection.SecuredPartyRightsEventElectionBuilder setRightsEvent(Boolean rightsEvent);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("party"), CounterpartyRoleEnum.class, getParty(), this);
			processor.processBasic(path.newSubPath("rightsEvent"), Boolean.class, getRightsEvent(), this);
		}
		

		SecuredPartyRightsEventElection.SecuredPartyRightsEventElectionBuilder prune();
	}

	/*********************** Immutable Implementation of SecuredPartyRightsEventElection  ***********************/
	class SecuredPartyRightsEventElectionImpl implements SecuredPartyRightsEventElection {
		private final CounterpartyRoleEnum party;
		private final Boolean rightsEvent;
		
		protected SecuredPartyRightsEventElectionImpl(SecuredPartyRightsEventElection.SecuredPartyRightsEventElectionBuilder builder) {
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
		public SecuredPartyRightsEventElection build() {
			return this;
		}
		
		@Override
		public SecuredPartyRightsEventElection.SecuredPartyRightsEventElectionBuilder toBuilder() {
			SecuredPartyRightsEventElection.SecuredPartyRightsEventElectionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SecuredPartyRightsEventElection.SecuredPartyRightsEventElectionBuilder builder) {
			ofNullable(getParty()).ifPresent(builder::setParty);
			ofNullable(getRightsEvent()).ifPresent(builder::setRightsEvent);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SecuredPartyRightsEventElection _that = getType().cast(o);
		
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
			return "SecuredPartyRightsEventElection {" +
				"party=" + this.party + ", " +
				"rightsEvent=" + this.rightsEvent +
			'}';
		}
	}

	/*********************** Builder Implementation of SecuredPartyRightsEventElection  ***********************/
	class SecuredPartyRightsEventElectionBuilderImpl implements SecuredPartyRightsEventElection.SecuredPartyRightsEventElectionBuilder {
	
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
		public SecuredPartyRightsEventElection.SecuredPartyRightsEventElectionBuilder setParty(CounterpartyRoleEnum _party) {
			this.party = _party == null ? null : _party;
			return this;
		}
		
		@RosettaAttribute("rightsEvent")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("rightsEvent")
		@Override
		public SecuredPartyRightsEventElection.SecuredPartyRightsEventElectionBuilder setRightsEvent(Boolean _rightsEvent) {
			this.rightsEvent = _rightsEvent == null ? null : _rightsEvent;
			return this;
		}
		
		@Override
		public SecuredPartyRightsEventElection build() {
			return new SecuredPartyRightsEventElection.SecuredPartyRightsEventElectionImpl(this);
		}
		
		@Override
		public SecuredPartyRightsEventElection.SecuredPartyRightsEventElectionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SecuredPartyRightsEventElection.SecuredPartyRightsEventElectionBuilder prune() {
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
		public SecuredPartyRightsEventElection.SecuredPartyRightsEventElectionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			SecuredPartyRightsEventElection.SecuredPartyRightsEventElectionBuilder o = (SecuredPartyRightsEventElection.SecuredPartyRightsEventElectionBuilder) other;
			
			
			merger.mergeBasic(getParty(), o.getParty(), this::setParty);
			merger.mergeBasic(getRightsEvent(), o.getRightsEvent(), this::setRightsEvent);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SecuredPartyRightsEventElection _that = getType().cast(o);
		
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
			return "SecuredPartyRightsEventElectionBuilder {" +
				"party=" + this.party + ", " +
				"rightsEvent=" + this.rightsEvent +
			'}';
		}
	}
}
