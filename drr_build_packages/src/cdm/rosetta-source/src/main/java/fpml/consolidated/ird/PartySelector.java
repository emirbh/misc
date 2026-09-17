package fpml.consolidated.ird;

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
import fpml.consolidated.fpmlenum.PartyDeterminationEnum;
import fpml.consolidated.ird.meta.PartySelectorMeta;
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
@RosettaDataType(value="PartySelector", builder=PartySelector.PartySelectorBuilderImpl.class, version="2.1.1")
@RuneDataType(value="PartySelector", model="fpml", builder=PartySelector.PartySelectorBuilderImpl.class, version="2.1.1")
public interface PartySelector extends RosettaModelObject {

	PartySelectorMeta metaData = new PartySelectorMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The party specific party that is referenced.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The party specific party that is referenced.
	 *
	 */
	PartyReference getPartyReference();
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
	PartyDeterminationEnum getPartyDetermination();

	/*********************** Build Methods  ***********************/
	PartySelector build();
	
	PartySelector.PartySelectorBuilder toBuilder();
	
	static PartySelector.PartySelectorBuilder builder() {
		return new PartySelector.PartySelectorBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PartySelector> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends PartySelector> getType() {
		return PartySelector.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("partyReference"), processor, PartyReference.class, getPartyReference());
		processor.processBasic(path.newSubPath("partyDetermination"), PartyDeterminationEnum.class, getPartyDetermination(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface PartySelectorBuilder extends PartySelector, RosettaModelObjectBuilder {
		PartyReference.PartyReferenceBuilder getOrCreatePartyReference();
		@Override
		PartyReference.PartyReferenceBuilder getPartyReference();
		PartySelector.PartySelectorBuilder setPartyReference(PartyReference partyReference);
		PartySelector.PartySelectorBuilder setPartyDetermination(PartyDeterminationEnum partyDetermination);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("partyReference"), processor, PartyReference.PartyReferenceBuilder.class, getPartyReference());
			processor.processBasic(path.newSubPath("partyDetermination"), PartyDeterminationEnum.class, getPartyDetermination(), this);
		}
		

		PartySelector.PartySelectorBuilder prune();
	}

	/*********************** Immutable Implementation of PartySelector  ***********************/
	class PartySelectorImpl implements PartySelector {
		private final PartyReference partyReference;
		private final PartyDeterminationEnum partyDetermination;
		
		protected PartySelectorImpl(PartySelector.PartySelectorBuilder builder) {
			this.partyReference = ofNullable(builder.getPartyReference()).map(f->f.build()).orElse(null);
			this.partyDetermination = builder.getPartyDetermination();
		}
		
		@Override
		@RosettaAttribute("partyReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("partyReference")
		public PartyReference getPartyReference() {
			return partyReference;
		}
		
		@Override
		@RosettaAttribute("partyDetermination")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("partyDetermination")
		public PartyDeterminationEnum getPartyDetermination() {
			return partyDetermination;
		}
		
		@Override
		public PartySelector build() {
			return this;
		}
		
		@Override
		public PartySelector.PartySelectorBuilder toBuilder() {
			PartySelector.PartySelectorBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PartySelector.PartySelectorBuilder builder) {
			ofNullable(getPartyReference()).ifPresent(builder::setPartyReference);
			ofNullable(getPartyDetermination()).ifPresent(builder::setPartyDetermination);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PartySelector _that = getType().cast(o);
		
			if (!Objects.equals(partyReference, _that.getPartyReference())) return false;
			if (!Objects.equals(partyDetermination, _that.getPartyDetermination())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (partyReference != null ? partyReference.hashCode() : 0);
			_result = 31 * _result + (partyDetermination != null ? partyDetermination.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PartySelector {" +
				"partyReference=" + this.partyReference + ", " +
				"partyDetermination=" + this.partyDetermination +
			'}';
		}
	}

	/*********************** Builder Implementation of PartySelector  ***********************/
	class PartySelectorBuilderImpl implements PartySelector.PartySelectorBuilder {
	
		protected PartyReference.PartyReferenceBuilder partyReference;
		protected PartyDeterminationEnum partyDetermination;
		
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
		@RosettaAttribute("partyDetermination")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("partyDetermination")
		public PartyDeterminationEnum getPartyDetermination() {
			return partyDetermination;
		}
		
		@RosettaAttribute("partyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("partyReference")
		@Override
		public PartySelector.PartySelectorBuilder setPartyReference(PartyReference _partyReference) {
			this.partyReference = _partyReference == null ? null : _partyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("partyDetermination")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("partyDetermination")
		@Override
		public PartySelector.PartySelectorBuilder setPartyDetermination(PartyDeterminationEnum _partyDetermination) {
			this.partyDetermination = _partyDetermination == null ? null : _partyDetermination;
			return this;
		}
		
		@Override
		public PartySelector build() {
			return new PartySelector.PartySelectorImpl(this);
		}
		
		@Override
		public PartySelector.PartySelectorBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PartySelector.PartySelectorBuilder prune() {
			if (partyReference!=null && !partyReference.prune().hasData()) partyReference = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPartyReference()!=null && getPartyReference().hasData()) return true;
			if (getPartyDetermination()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PartySelector.PartySelectorBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PartySelector.PartySelectorBuilder o = (PartySelector.PartySelectorBuilder) other;
			
			merger.mergeRosetta(getPartyReference(), o.getPartyReference(), this::setPartyReference);
			
			merger.mergeBasic(getPartyDetermination(), o.getPartyDetermination(), this::setPartyDetermination);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PartySelector _that = getType().cast(o);
		
			if (!Objects.equals(partyReference, _that.getPartyReference())) return false;
			if (!Objects.equals(partyDetermination, _that.getPartyDetermination())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (partyReference != null ? partyReference.hashCode() : 0);
			_result = 31 * _result + (partyDetermination != null ? partyDetermination.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PartySelectorBuilder {" +
				"partyReference=" + this.partyReference + ", " +
				"partyDetermination=" + this.partyDetermination +
			'}';
		}
	}
}
