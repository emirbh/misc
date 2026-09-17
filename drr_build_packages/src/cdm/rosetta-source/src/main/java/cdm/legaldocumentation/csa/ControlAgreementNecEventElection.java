package cdm.legaldocumentation.csa;

import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.legaldocumentation.csa.meta.ControlAgreementNecEventElectionMeta;
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
 * A class to specify party specific Control Agreement language related to delivery of a Notice of Exclusive Control.
 * @version 6.23.0
 */
@RosettaDataType(value="ControlAgreementNecEventElection", builder=ControlAgreementNecEventElection.ControlAgreementNecEventElectionBuilderImpl.class, version="6.23.0")
@RuneDataType(value="ControlAgreementNecEventElection", model="cdm", builder=ControlAgreementNecEventElection.ControlAgreementNecEventElectionBuilderImpl.class, version="6.23.0")
public interface ControlAgreementNecEventElection extends RosettaModelObject {

	ControlAgreementNecEventElectionMeta metaData = new ControlAgreementNecEventElectionMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The elective party.
	 */
	CounterpartyRoleEnum getParty();
	/**
	 * Indicates Control Agreement language related to delivery of a Notice of Exclusive Control.
	 */
	Boolean getNecEvent();

	/*********************** Build Methods  ***********************/
	ControlAgreementNecEventElection build();
	
	ControlAgreementNecEventElection.ControlAgreementNecEventElectionBuilder toBuilder();
	
	static ControlAgreementNecEventElection.ControlAgreementNecEventElectionBuilder builder() {
		return new ControlAgreementNecEventElection.ControlAgreementNecEventElectionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ControlAgreementNecEventElection> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ControlAgreementNecEventElection> getType() {
		return ControlAgreementNecEventElection.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("party"), CounterpartyRoleEnum.class, getParty(), this);
		processor.processBasic(path.newSubPath("necEvent"), Boolean.class, getNecEvent(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ControlAgreementNecEventElectionBuilder extends ControlAgreementNecEventElection, RosettaModelObjectBuilder {
		ControlAgreementNecEventElection.ControlAgreementNecEventElectionBuilder setParty(CounterpartyRoleEnum party);
		ControlAgreementNecEventElection.ControlAgreementNecEventElectionBuilder setNecEvent(Boolean necEvent);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("party"), CounterpartyRoleEnum.class, getParty(), this);
			processor.processBasic(path.newSubPath("necEvent"), Boolean.class, getNecEvent(), this);
		}
		

		ControlAgreementNecEventElection.ControlAgreementNecEventElectionBuilder prune();
	}

	/*********************** Immutable Implementation of ControlAgreementNecEventElection  ***********************/
	class ControlAgreementNecEventElectionImpl implements ControlAgreementNecEventElection {
		private final CounterpartyRoleEnum party;
		private final Boolean necEvent;
		
		protected ControlAgreementNecEventElectionImpl(ControlAgreementNecEventElection.ControlAgreementNecEventElectionBuilder builder) {
			this.party = builder.getParty();
			this.necEvent = builder.getNecEvent();
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
		@RosettaAttribute("necEvent")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("necEvent")
		public Boolean getNecEvent() {
			return necEvent;
		}
		
		@Override
		public ControlAgreementNecEventElection build() {
			return this;
		}
		
		@Override
		public ControlAgreementNecEventElection.ControlAgreementNecEventElectionBuilder toBuilder() {
			ControlAgreementNecEventElection.ControlAgreementNecEventElectionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ControlAgreementNecEventElection.ControlAgreementNecEventElectionBuilder builder) {
			ofNullable(getParty()).ifPresent(builder::setParty);
			ofNullable(getNecEvent()).ifPresent(builder::setNecEvent);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ControlAgreementNecEventElection _that = getType().cast(o);
		
			if (!Objects.equals(party, _that.getParty())) return false;
			if (!Objects.equals(necEvent, _that.getNecEvent())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (party != null ? party.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (necEvent != null ? necEvent.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ControlAgreementNecEventElection {" +
				"party=" + this.party + ", " +
				"necEvent=" + this.necEvent +
			'}';
		}
	}

	/*********************** Builder Implementation of ControlAgreementNecEventElection  ***********************/
	class ControlAgreementNecEventElectionBuilderImpl implements ControlAgreementNecEventElection.ControlAgreementNecEventElectionBuilder {
	
		protected CounterpartyRoleEnum party;
		protected Boolean necEvent;
		
		@Override
		@RosettaAttribute("party")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("party")
		public CounterpartyRoleEnum getParty() {
			return party;
		}
		
		@Override
		@RosettaAttribute("necEvent")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("necEvent")
		public Boolean getNecEvent() {
			return necEvent;
		}
		
		@RosettaAttribute("party")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("party")
		@Override
		public ControlAgreementNecEventElection.ControlAgreementNecEventElectionBuilder setParty(CounterpartyRoleEnum _party) {
			this.party = _party == null ? null : _party;
			return this;
		}
		
		@RosettaAttribute("necEvent")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("necEvent")
		@Override
		public ControlAgreementNecEventElection.ControlAgreementNecEventElectionBuilder setNecEvent(Boolean _necEvent) {
			this.necEvent = _necEvent == null ? null : _necEvent;
			return this;
		}
		
		@Override
		public ControlAgreementNecEventElection build() {
			return new ControlAgreementNecEventElection.ControlAgreementNecEventElectionImpl(this);
		}
		
		@Override
		public ControlAgreementNecEventElection.ControlAgreementNecEventElectionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ControlAgreementNecEventElection.ControlAgreementNecEventElectionBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getParty()!=null) return true;
			if (getNecEvent()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ControlAgreementNecEventElection.ControlAgreementNecEventElectionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ControlAgreementNecEventElection.ControlAgreementNecEventElectionBuilder o = (ControlAgreementNecEventElection.ControlAgreementNecEventElectionBuilder) other;
			
			
			merger.mergeBasic(getParty(), o.getParty(), this::setParty);
			merger.mergeBasic(getNecEvent(), o.getNecEvent(), this::setNecEvent);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ControlAgreementNecEventElection _that = getType().cast(o);
		
			if (!Objects.equals(party, _that.getParty())) return false;
			if (!Objects.equals(necEvent, _that.getNecEvent())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (party != null ? party.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (necEvent != null ? necEvent.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ControlAgreementNecEventElectionBuilder {" +
				"party=" + this.party + ", " +
				"necEvent=" + this.necEvent +
			'}';
		}
	}
}
