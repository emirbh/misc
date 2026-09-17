package cdm.legaldocumentation.csa;

import cdm.legaldocumentation.csa.meta.RightsEventsMeta;
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
 * A class to specify the rights of Security Taker and/or Security Provider when an Early Termination or Access Condition event has occurred.
 * @version 6.23.0
 */
@RosettaDataType(value="RightsEvents", builder=RightsEvents.RightsEventsBuilderImpl.class, version="6.23.0")
@RuneDataType(value="RightsEvents", model="cdm", builder=RightsEvents.RightsEventsBuilderImpl.class, version="6.23.0")
public interface RightsEvents extends RosettaModelObject {

	RightsEventsMeta metaData = new RightsEventsMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The bespoke provisions that might be specified by the parties to the agreement applicable to a Security Taker Rights Event.
	 */
	SecuredPartyRightsEvent getSecurityTakerRightsEvent();
	/**
	 * The bespoke provisions that might be specified by the parties to the agreement applicable to a Notice of Exclusive Control Event.
	 */
	ControlAgreementNecEvent getControlAgreementNecEvent();
	/**
	 * The bespoke provisions that might be specified by the parties to the agreement applicable to a Security Provider Rights Event.
	 */
	SecurityProviderRightsEvent getSecurityProviderRightsEvent();
	/**
	 * The specification of whether Delivery In Lieu language is applicable to the agreement (true) or not (false).
	 */
	Boolean getDeliveryInLieuRight();
	/**
	 * The Additional Rights Event election.
	 */
	AdditionalRightsEvent getAdditionalRightsEvent();

	/*********************** Build Methods  ***********************/
	RightsEvents build();
	
	RightsEvents.RightsEventsBuilder toBuilder();
	
	static RightsEvents.RightsEventsBuilder builder() {
		return new RightsEvents.RightsEventsBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends RightsEvents> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends RightsEvents> getType() {
		return RightsEvents.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("securityTakerRightsEvent"), processor, SecuredPartyRightsEvent.class, getSecurityTakerRightsEvent());
		processRosetta(path.newSubPath("controlAgreementNecEvent"), processor, ControlAgreementNecEvent.class, getControlAgreementNecEvent());
		processRosetta(path.newSubPath("securityProviderRightsEvent"), processor, SecurityProviderRightsEvent.class, getSecurityProviderRightsEvent());
		processor.processBasic(path.newSubPath("deliveryInLieuRight"), Boolean.class, getDeliveryInLieuRight(), this);
		processRosetta(path.newSubPath("additionalRightsEvent"), processor, AdditionalRightsEvent.class, getAdditionalRightsEvent());
	}
	

	/*********************** Builder Interface  ***********************/
	interface RightsEventsBuilder extends RightsEvents, RosettaModelObjectBuilder {
		SecuredPartyRightsEvent.SecuredPartyRightsEventBuilder getOrCreateSecurityTakerRightsEvent();
		@Override
		SecuredPartyRightsEvent.SecuredPartyRightsEventBuilder getSecurityTakerRightsEvent();
		ControlAgreementNecEvent.ControlAgreementNecEventBuilder getOrCreateControlAgreementNecEvent();
		@Override
		ControlAgreementNecEvent.ControlAgreementNecEventBuilder getControlAgreementNecEvent();
		SecurityProviderRightsEvent.SecurityProviderRightsEventBuilder getOrCreateSecurityProviderRightsEvent();
		@Override
		SecurityProviderRightsEvent.SecurityProviderRightsEventBuilder getSecurityProviderRightsEvent();
		AdditionalRightsEvent.AdditionalRightsEventBuilder getOrCreateAdditionalRightsEvent();
		@Override
		AdditionalRightsEvent.AdditionalRightsEventBuilder getAdditionalRightsEvent();
		RightsEvents.RightsEventsBuilder setSecurityTakerRightsEvent(SecuredPartyRightsEvent securityTakerRightsEvent);
		RightsEvents.RightsEventsBuilder setControlAgreementNecEvent(ControlAgreementNecEvent controlAgreementNecEvent);
		RightsEvents.RightsEventsBuilder setSecurityProviderRightsEvent(SecurityProviderRightsEvent securityProviderRightsEvent);
		RightsEvents.RightsEventsBuilder setDeliveryInLieuRight(Boolean deliveryInLieuRight);
		RightsEvents.RightsEventsBuilder setAdditionalRightsEvent(AdditionalRightsEvent additionalRightsEvent);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("securityTakerRightsEvent"), processor, SecuredPartyRightsEvent.SecuredPartyRightsEventBuilder.class, getSecurityTakerRightsEvent());
			processRosetta(path.newSubPath("controlAgreementNecEvent"), processor, ControlAgreementNecEvent.ControlAgreementNecEventBuilder.class, getControlAgreementNecEvent());
			processRosetta(path.newSubPath("securityProviderRightsEvent"), processor, SecurityProviderRightsEvent.SecurityProviderRightsEventBuilder.class, getSecurityProviderRightsEvent());
			processor.processBasic(path.newSubPath("deliveryInLieuRight"), Boolean.class, getDeliveryInLieuRight(), this);
			processRosetta(path.newSubPath("additionalRightsEvent"), processor, AdditionalRightsEvent.AdditionalRightsEventBuilder.class, getAdditionalRightsEvent());
		}
		

		RightsEvents.RightsEventsBuilder prune();
	}

	/*********************** Immutable Implementation of RightsEvents  ***********************/
	class RightsEventsImpl implements RightsEvents {
		private final SecuredPartyRightsEvent securityTakerRightsEvent;
		private final ControlAgreementNecEvent controlAgreementNecEvent;
		private final SecurityProviderRightsEvent securityProviderRightsEvent;
		private final Boolean deliveryInLieuRight;
		private final AdditionalRightsEvent additionalRightsEvent;
		
		protected RightsEventsImpl(RightsEvents.RightsEventsBuilder builder) {
			this.securityTakerRightsEvent = ofNullable(builder.getSecurityTakerRightsEvent()).map(f->f.build()).orElse(null);
			this.controlAgreementNecEvent = ofNullable(builder.getControlAgreementNecEvent()).map(f->f.build()).orElse(null);
			this.securityProviderRightsEvent = ofNullable(builder.getSecurityProviderRightsEvent()).map(f->f.build()).orElse(null);
			this.deliveryInLieuRight = builder.getDeliveryInLieuRight();
			this.additionalRightsEvent = ofNullable(builder.getAdditionalRightsEvent()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("securityTakerRightsEvent")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("securityTakerRightsEvent")
		public SecuredPartyRightsEvent getSecurityTakerRightsEvent() {
			return securityTakerRightsEvent;
		}
		
		@Override
		@RosettaAttribute("controlAgreementNecEvent")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("controlAgreementNecEvent")
		public ControlAgreementNecEvent getControlAgreementNecEvent() {
			return controlAgreementNecEvent;
		}
		
		@Override
		@RosettaAttribute("securityProviderRightsEvent")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("securityProviderRightsEvent")
		public SecurityProviderRightsEvent getSecurityProviderRightsEvent() {
			return securityProviderRightsEvent;
		}
		
		@Override
		@RosettaAttribute("deliveryInLieuRight")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("deliveryInLieuRight")
		public Boolean getDeliveryInLieuRight() {
			return deliveryInLieuRight;
		}
		
		@Override
		@RosettaAttribute("additionalRightsEvent")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("additionalRightsEvent")
		public AdditionalRightsEvent getAdditionalRightsEvent() {
			return additionalRightsEvent;
		}
		
		@Override
		public RightsEvents build() {
			return this;
		}
		
		@Override
		public RightsEvents.RightsEventsBuilder toBuilder() {
			RightsEvents.RightsEventsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(RightsEvents.RightsEventsBuilder builder) {
			ofNullable(getSecurityTakerRightsEvent()).ifPresent(builder::setSecurityTakerRightsEvent);
			ofNullable(getControlAgreementNecEvent()).ifPresent(builder::setControlAgreementNecEvent);
			ofNullable(getSecurityProviderRightsEvent()).ifPresent(builder::setSecurityProviderRightsEvent);
			ofNullable(getDeliveryInLieuRight()).ifPresent(builder::setDeliveryInLieuRight);
			ofNullable(getAdditionalRightsEvent()).ifPresent(builder::setAdditionalRightsEvent);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			RightsEvents _that = getType().cast(o);
		
			if (!Objects.equals(securityTakerRightsEvent, _that.getSecurityTakerRightsEvent())) return false;
			if (!Objects.equals(controlAgreementNecEvent, _that.getControlAgreementNecEvent())) return false;
			if (!Objects.equals(securityProviderRightsEvent, _that.getSecurityProviderRightsEvent())) return false;
			if (!Objects.equals(deliveryInLieuRight, _that.getDeliveryInLieuRight())) return false;
			if (!Objects.equals(additionalRightsEvent, _that.getAdditionalRightsEvent())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (securityTakerRightsEvent != null ? securityTakerRightsEvent.hashCode() : 0);
			_result = 31 * _result + (controlAgreementNecEvent != null ? controlAgreementNecEvent.hashCode() : 0);
			_result = 31 * _result + (securityProviderRightsEvent != null ? securityProviderRightsEvent.hashCode() : 0);
			_result = 31 * _result + (deliveryInLieuRight != null ? deliveryInLieuRight.hashCode() : 0);
			_result = 31 * _result + (additionalRightsEvent != null ? additionalRightsEvent.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RightsEvents {" +
				"securityTakerRightsEvent=" + this.securityTakerRightsEvent + ", " +
				"controlAgreementNecEvent=" + this.controlAgreementNecEvent + ", " +
				"securityProviderRightsEvent=" + this.securityProviderRightsEvent + ", " +
				"deliveryInLieuRight=" + this.deliveryInLieuRight + ", " +
				"additionalRightsEvent=" + this.additionalRightsEvent +
			'}';
		}
	}

	/*********************** Builder Implementation of RightsEvents  ***********************/
	class RightsEventsBuilderImpl implements RightsEvents.RightsEventsBuilder {
	
		protected SecuredPartyRightsEvent.SecuredPartyRightsEventBuilder securityTakerRightsEvent;
		protected ControlAgreementNecEvent.ControlAgreementNecEventBuilder controlAgreementNecEvent;
		protected SecurityProviderRightsEvent.SecurityProviderRightsEventBuilder securityProviderRightsEvent;
		protected Boolean deliveryInLieuRight;
		protected AdditionalRightsEvent.AdditionalRightsEventBuilder additionalRightsEvent;
		
		@Override
		@RosettaAttribute("securityTakerRightsEvent")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("securityTakerRightsEvent")
		public SecuredPartyRightsEvent.SecuredPartyRightsEventBuilder getSecurityTakerRightsEvent() {
			return securityTakerRightsEvent;
		}
		
		@Override
		public SecuredPartyRightsEvent.SecuredPartyRightsEventBuilder getOrCreateSecurityTakerRightsEvent() {
			SecuredPartyRightsEvent.SecuredPartyRightsEventBuilder result;
			if (securityTakerRightsEvent!=null) {
				result = securityTakerRightsEvent;
			}
			else {
				result = securityTakerRightsEvent = SecuredPartyRightsEvent.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("controlAgreementNecEvent")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("controlAgreementNecEvent")
		public ControlAgreementNecEvent.ControlAgreementNecEventBuilder getControlAgreementNecEvent() {
			return controlAgreementNecEvent;
		}
		
		@Override
		public ControlAgreementNecEvent.ControlAgreementNecEventBuilder getOrCreateControlAgreementNecEvent() {
			ControlAgreementNecEvent.ControlAgreementNecEventBuilder result;
			if (controlAgreementNecEvent!=null) {
				result = controlAgreementNecEvent;
			}
			else {
				result = controlAgreementNecEvent = ControlAgreementNecEvent.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("securityProviderRightsEvent")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("securityProviderRightsEvent")
		public SecurityProviderRightsEvent.SecurityProviderRightsEventBuilder getSecurityProviderRightsEvent() {
			return securityProviderRightsEvent;
		}
		
		@Override
		public SecurityProviderRightsEvent.SecurityProviderRightsEventBuilder getOrCreateSecurityProviderRightsEvent() {
			SecurityProviderRightsEvent.SecurityProviderRightsEventBuilder result;
			if (securityProviderRightsEvent!=null) {
				result = securityProviderRightsEvent;
			}
			else {
				result = securityProviderRightsEvent = SecurityProviderRightsEvent.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("deliveryInLieuRight")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("deliveryInLieuRight")
		public Boolean getDeliveryInLieuRight() {
			return deliveryInLieuRight;
		}
		
		@Override
		@RosettaAttribute("additionalRightsEvent")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("additionalRightsEvent")
		public AdditionalRightsEvent.AdditionalRightsEventBuilder getAdditionalRightsEvent() {
			return additionalRightsEvent;
		}
		
		@Override
		public AdditionalRightsEvent.AdditionalRightsEventBuilder getOrCreateAdditionalRightsEvent() {
			AdditionalRightsEvent.AdditionalRightsEventBuilder result;
			if (additionalRightsEvent!=null) {
				result = additionalRightsEvent;
			}
			else {
				result = additionalRightsEvent = AdditionalRightsEvent.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("securityTakerRightsEvent")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("securityTakerRightsEvent")
		@Override
		public RightsEvents.RightsEventsBuilder setSecurityTakerRightsEvent(SecuredPartyRightsEvent _securityTakerRightsEvent) {
			this.securityTakerRightsEvent = _securityTakerRightsEvent == null ? null : _securityTakerRightsEvent.toBuilder();
			return this;
		}
		
		@RosettaAttribute("controlAgreementNecEvent")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("controlAgreementNecEvent")
		@Override
		public RightsEvents.RightsEventsBuilder setControlAgreementNecEvent(ControlAgreementNecEvent _controlAgreementNecEvent) {
			this.controlAgreementNecEvent = _controlAgreementNecEvent == null ? null : _controlAgreementNecEvent.toBuilder();
			return this;
		}
		
		@RosettaAttribute("securityProviderRightsEvent")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("securityProviderRightsEvent")
		@Override
		public RightsEvents.RightsEventsBuilder setSecurityProviderRightsEvent(SecurityProviderRightsEvent _securityProviderRightsEvent) {
			this.securityProviderRightsEvent = _securityProviderRightsEvent == null ? null : _securityProviderRightsEvent.toBuilder();
			return this;
		}
		
		@RosettaAttribute("deliveryInLieuRight")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("deliveryInLieuRight")
		@Override
		public RightsEvents.RightsEventsBuilder setDeliveryInLieuRight(Boolean _deliveryInLieuRight) {
			this.deliveryInLieuRight = _deliveryInLieuRight == null ? null : _deliveryInLieuRight;
			return this;
		}
		
		@RosettaAttribute("additionalRightsEvent")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("additionalRightsEvent")
		@Override
		public RightsEvents.RightsEventsBuilder setAdditionalRightsEvent(AdditionalRightsEvent _additionalRightsEvent) {
			this.additionalRightsEvent = _additionalRightsEvent == null ? null : _additionalRightsEvent.toBuilder();
			return this;
		}
		
		@Override
		public RightsEvents build() {
			return new RightsEvents.RightsEventsImpl(this);
		}
		
		@Override
		public RightsEvents.RightsEventsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RightsEvents.RightsEventsBuilder prune() {
			if (securityTakerRightsEvent!=null && !securityTakerRightsEvent.prune().hasData()) securityTakerRightsEvent = null;
			if (controlAgreementNecEvent!=null && !controlAgreementNecEvent.prune().hasData()) controlAgreementNecEvent = null;
			if (securityProviderRightsEvent!=null && !securityProviderRightsEvent.prune().hasData()) securityProviderRightsEvent = null;
			if (additionalRightsEvent!=null && !additionalRightsEvent.prune().hasData()) additionalRightsEvent = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getSecurityTakerRightsEvent()!=null && getSecurityTakerRightsEvent().hasData()) return true;
			if (getControlAgreementNecEvent()!=null && getControlAgreementNecEvent().hasData()) return true;
			if (getSecurityProviderRightsEvent()!=null && getSecurityProviderRightsEvent().hasData()) return true;
			if (getDeliveryInLieuRight()!=null) return true;
			if (getAdditionalRightsEvent()!=null && getAdditionalRightsEvent().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RightsEvents.RightsEventsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			RightsEvents.RightsEventsBuilder o = (RightsEvents.RightsEventsBuilder) other;
			
			merger.mergeRosetta(getSecurityTakerRightsEvent(), o.getSecurityTakerRightsEvent(), this::setSecurityTakerRightsEvent);
			merger.mergeRosetta(getControlAgreementNecEvent(), o.getControlAgreementNecEvent(), this::setControlAgreementNecEvent);
			merger.mergeRosetta(getSecurityProviderRightsEvent(), o.getSecurityProviderRightsEvent(), this::setSecurityProviderRightsEvent);
			merger.mergeRosetta(getAdditionalRightsEvent(), o.getAdditionalRightsEvent(), this::setAdditionalRightsEvent);
			
			merger.mergeBasic(getDeliveryInLieuRight(), o.getDeliveryInLieuRight(), this::setDeliveryInLieuRight);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			RightsEvents _that = getType().cast(o);
		
			if (!Objects.equals(securityTakerRightsEvent, _that.getSecurityTakerRightsEvent())) return false;
			if (!Objects.equals(controlAgreementNecEvent, _that.getControlAgreementNecEvent())) return false;
			if (!Objects.equals(securityProviderRightsEvent, _that.getSecurityProviderRightsEvent())) return false;
			if (!Objects.equals(deliveryInLieuRight, _that.getDeliveryInLieuRight())) return false;
			if (!Objects.equals(additionalRightsEvent, _that.getAdditionalRightsEvent())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (securityTakerRightsEvent != null ? securityTakerRightsEvent.hashCode() : 0);
			_result = 31 * _result + (controlAgreementNecEvent != null ? controlAgreementNecEvent.hashCode() : 0);
			_result = 31 * _result + (securityProviderRightsEvent != null ? securityProviderRightsEvent.hashCode() : 0);
			_result = 31 * _result + (deliveryInLieuRight != null ? deliveryInLieuRight.hashCode() : 0);
			_result = 31 * _result + (additionalRightsEvent != null ? additionalRightsEvent.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RightsEventsBuilder {" +
				"securityTakerRightsEvent=" + this.securityTakerRightsEvent + ", " +
				"controlAgreementNecEvent=" + this.controlAgreementNecEvent + ", " +
				"securityProviderRightsEvent=" + this.securityProviderRightsEvent + ", " +
				"deliveryInLieuRight=" + this.deliveryInLieuRight + ", " +
				"additionalRightsEvent=" + this.additionalRightsEvent +
			'}';
		}
	}
}
