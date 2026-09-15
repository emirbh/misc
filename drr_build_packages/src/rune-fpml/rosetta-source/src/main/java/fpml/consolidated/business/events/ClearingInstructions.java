package fpml.consolidated.business.events;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import fpml.consolidated.business.events.meta.ClearingInstructionsMeta;
import fpml.consolidated.shared.PartyReference;
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
@RosettaDataType(value="ClearingInstructions", builder=ClearingInstructions.ClearingInstructionsBuilderImpl.class, version="2.1.1")
@RuneDataType(value="ClearingInstructions", model="fpml", builder=ClearingInstructions.ClearingInstructionsBuilderImpl.class, version="2.1.1")
public interface ClearingInstructions extends RosettaModelObject {

	ClearingInstructionsMeta metaData = new ClearingInstructionsMeta();

	/*********************** Getter Methods  ***********************/
	/**
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
	RequestedClearingAction getRequestedClearingAction();
	/**
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
	PartyReference getRequestedClearingOrganizationPartyReference();

	/*********************** Build Methods  ***********************/
	ClearingInstructions build();
	
	ClearingInstructions.ClearingInstructionsBuilder toBuilder();
	
	static ClearingInstructions.ClearingInstructionsBuilder builder() {
		return new ClearingInstructions.ClearingInstructionsBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ClearingInstructions> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ClearingInstructions> getType() {
		return ClearingInstructions.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("requestedClearingAction"), processor, RequestedClearingAction.class, getRequestedClearingAction());
		processRosetta(path.newSubPath("requestedClearingOrganizationPartyReference"), processor, PartyReference.class, getRequestedClearingOrganizationPartyReference());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ClearingInstructionsBuilder extends ClearingInstructions, RosettaModelObjectBuilder {
		RequestedClearingAction.RequestedClearingActionBuilder getOrCreateRequestedClearingAction();
		@Override
		RequestedClearingAction.RequestedClearingActionBuilder getRequestedClearingAction();
		PartyReference.PartyReferenceBuilder getOrCreateRequestedClearingOrganizationPartyReference();
		@Override
		PartyReference.PartyReferenceBuilder getRequestedClearingOrganizationPartyReference();
		ClearingInstructions.ClearingInstructionsBuilder setRequestedClearingAction(RequestedClearingAction requestedClearingAction);
		ClearingInstructions.ClearingInstructionsBuilder setRequestedClearingOrganizationPartyReference(PartyReference requestedClearingOrganizationPartyReference);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("requestedClearingAction"), processor, RequestedClearingAction.RequestedClearingActionBuilder.class, getRequestedClearingAction());
			processRosetta(path.newSubPath("requestedClearingOrganizationPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getRequestedClearingOrganizationPartyReference());
		}
		

		ClearingInstructions.ClearingInstructionsBuilder prune();
	}

	/*********************** Immutable Implementation of ClearingInstructions  ***********************/
	class ClearingInstructionsImpl implements ClearingInstructions {
		private final RequestedClearingAction requestedClearingAction;
		private final PartyReference requestedClearingOrganizationPartyReference;
		
		protected ClearingInstructionsImpl(ClearingInstructions.ClearingInstructionsBuilder builder) {
			this.requestedClearingAction = ofNullable(builder.getRequestedClearingAction()).map(f->f.build()).orElse(null);
			this.requestedClearingOrganizationPartyReference = ofNullable(builder.getRequestedClearingOrganizationPartyReference()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("requestedClearingAction")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("requestedClearingAction")
		public RequestedClearingAction getRequestedClearingAction() {
			return requestedClearingAction;
		}
		
		@Override
		@RosettaAttribute("requestedClearingOrganizationPartyReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("requestedClearingOrganizationPartyReference")
		public PartyReference getRequestedClearingOrganizationPartyReference() {
			return requestedClearingOrganizationPartyReference;
		}
		
		@Override
		public ClearingInstructions build() {
			return this;
		}
		
		@Override
		public ClearingInstructions.ClearingInstructionsBuilder toBuilder() {
			ClearingInstructions.ClearingInstructionsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ClearingInstructions.ClearingInstructionsBuilder builder) {
			ofNullable(getRequestedClearingAction()).ifPresent(builder::setRequestedClearingAction);
			ofNullable(getRequestedClearingOrganizationPartyReference()).ifPresent(builder::setRequestedClearingOrganizationPartyReference);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ClearingInstructions _that = getType().cast(o);
		
			if (!Objects.equals(requestedClearingAction, _that.getRequestedClearingAction())) return false;
			if (!Objects.equals(requestedClearingOrganizationPartyReference, _that.getRequestedClearingOrganizationPartyReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (requestedClearingAction != null ? requestedClearingAction.hashCode() : 0);
			_result = 31 * _result + (requestedClearingOrganizationPartyReference != null ? requestedClearingOrganizationPartyReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ClearingInstructions {" +
				"requestedClearingAction=" + this.requestedClearingAction + ", " +
				"requestedClearingOrganizationPartyReference=" + this.requestedClearingOrganizationPartyReference +
			'}';
		}
	}

	/*********************** Builder Implementation of ClearingInstructions  ***********************/
	class ClearingInstructionsBuilderImpl implements ClearingInstructions.ClearingInstructionsBuilder {
	
		protected RequestedClearingAction.RequestedClearingActionBuilder requestedClearingAction;
		protected PartyReference.PartyReferenceBuilder requestedClearingOrganizationPartyReference;
		
		@Override
		@RosettaAttribute("requestedClearingAction")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("requestedClearingAction")
		public RequestedClearingAction.RequestedClearingActionBuilder getRequestedClearingAction() {
			return requestedClearingAction;
		}
		
		@Override
		public RequestedClearingAction.RequestedClearingActionBuilder getOrCreateRequestedClearingAction() {
			RequestedClearingAction.RequestedClearingActionBuilder result;
			if (requestedClearingAction!=null) {
				result = requestedClearingAction;
			}
			else {
				result = requestedClearingAction = RequestedClearingAction.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("requestedClearingOrganizationPartyReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("requestedClearingOrganizationPartyReference")
		public PartyReference.PartyReferenceBuilder getRequestedClearingOrganizationPartyReference() {
			return requestedClearingOrganizationPartyReference;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreateRequestedClearingOrganizationPartyReference() {
			PartyReference.PartyReferenceBuilder result;
			if (requestedClearingOrganizationPartyReference!=null) {
				result = requestedClearingOrganizationPartyReference;
			}
			else {
				result = requestedClearingOrganizationPartyReference = PartyReference.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("requestedClearingAction")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("requestedClearingAction")
		@Override
		public ClearingInstructions.ClearingInstructionsBuilder setRequestedClearingAction(RequestedClearingAction _requestedClearingAction) {
			this.requestedClearingAction = _requestedClearingAction == null ? null : _requestedClearingAction.toBuilder();
			return this;
		}
		
		@RosettaAttribute("requestedClearingOrganizationPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("requestedClearingOrganizationPartyReference")
		@Override
		public ClearingInstructions.ClearingInstructionsBuilder setRequestedClearingOrganizationPartyReference(PartyReference _requestedClearingOrganizationPartyReference) {
			this.requestedClearingOrganizationPartyReference = _requestedClearingOrganizationPartyReference == null ? null : _requestedClearingOrganizationPartyReference.toBuilder();
			return this;
		}
		
		@Override
		public ClearingInstructions build() {
			return new ClearingInstructions.ClearingInstructionsImpl(this);
		}
		
		@Override
		public ClearingInstructions.ClearingInstructionsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ClearingInstructions.ClearingInstructionsBuilder prune() {
			if (requestedClearingAction!=null && !requestedClearingAction.prune().hasData()) requestedClearingAction = null;
			if (requestedClearingOrganizationPartyReference!=null && !requestedClearingOrganizationPartyReference.prune().hasData()) requestedClearingOrganizationPartyReference = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getRequestedClearingAction()!=null && getRequestedClearingAction().hasData()) return true;
			if (getRequestedClearingOrganizationPartyReference()!=null && getRequestedClearingOrganizationPartyReference().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ClearingInstructions.ClearingInstructionsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ClearingInstructions.ClearingInstructionsBuilder o = (ClearingInstructions.ClearingInstructionsBuilder) other;
			
			merger.mergeRosetta(getRequestedClearingAction(), o.getRequestedClearingAction(), this::setRequestedClearingAction);
			merger.mergeRosetta(getRequestedClearingOrganizationPartyReference(), o.getRequestedClearingOrganizationPartyReference(), this::setRequestedClearingOrganizationPartyReference);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ClearingInstructions _that = getType().cast(o);
		
			if (!Objects.equals(requestedClearingAction, _that.getRequestedClearingAction())) return false;
			if (!Objects.equals(requestedClearingOrganizationPartyReference, _that.getRequestedClearingOrganizationPartyReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (requestedClearingAction != null ? requestedClearingAction.hashCode() : 0);
			_result = 31 * _result + (requestedClearingOrganizationPartyReference != null ? requestedClearingOrganizationPartyReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ClearingInstructionsBuilder {" +
				"requestedClearingAction=" + this.requestedClearingAction + ", " +
				"requestedClearingOrganizationPartyReference=" + this.requestedClearingOrganizationPartyReference +
			'}';
		}
	}
}
