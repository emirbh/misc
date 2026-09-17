package fpml.consolidated.loan;

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
import fpml.consolidated.loan.meta.FacilityPositionMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A structure that represents current/prior facility commitment amounts on both the global and lender position levels.
 *
 */
@RosettaDataType(value="FacilityPosition", builder=FacilityPosition.FacilityPositionBuilderImpl.class, version="2.1.1")
@RuneDataType(value="FacilityPosition", model="fpml", builder=FacilityPosition.FacilityPositionBuilderImpl.class, version="2.1.1")
public interface FacilityPosition extends RosettaModelObject {

	FacilityPositionMeta metaData = new FacilityPositionMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A unique facility identifier.
	 *
	 */
	FacilityReference getFacilityReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The global and share amount of principal commitment. This is after any referenced business events have taken place.
	 *
	 */
	FacilityCommitment getCommitment();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The global and share amount of principal commitment. This is prior to any referenced business events.
	 *
	 */
	FacilityCommitment getPriorCommitment();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A structure used to define all positions held by the lender at the loan contract level. This structure is designed to hold either some or all loan contracts.
	 *
	 */
	List<? extends OutstandingsPosition> getOutstandingsPosition();

	/*********************** Build Methods  ***********************/
	FacilityPosition build();
	
	FacilityPosition.FacilityPositionBuilder toBuilder();
	
	static FacilityPosition.FacilityPositionBuilder builder() {
		return new FacilityPosition.FacilityPositionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FacilityPosition> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FacilityPosition> getType() {
		return FacilityPosition.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("facilityReference"), processor, FacilityReference.class, getFacilityReference());
		processRosetta(path.newSubPath("commitment"), processor, FacilityCommitment.class, getCommitment());
		processRosetta(path.newSubPath("priorCommitment"), processor, FacilityCommitment.class, getPriorCommitment());
		processRosetta(path.newSubPath("outstandingsPosition"), processor, OutstandingsPosition.class, getOutstandingsPosition());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FacilityPositionBuilder extends FacilityPosition, RosettaModelObjectBuilder {
		FacilityReference.FacilityReferenceBuilder getOrCreateFacilityReference();
		@Override
		FacilityReference.FacilityReferenceBuilder getFacilityReference();
		FacilityCommitment.FacilityCommitmentBuilder getOrCreateCommitment();
		@Override
		FacilityCommitment.FacilityCommitmentBuilder getCommitment();
		FacilityCommitment.FacilityCommitmentBuilder getOrCreatePriorCommitment();
		@Override
		FacilityCommitment.FacilityCommitmentBuilder getPriorCommitment();
		OutstandingsPosition.OutstandingsPositionBuilder getOrCreateOutstandingsPosition(int index);
		@Override
		List<? extends OutstandingsPosition.OutstandingsPositionBuilder> getOutstandingsPosition();
		FacilityPosition.FacilityPositionBuilder setFacilityReference(FacilityReference facilityReference);
		FacilityPosition.FacilityPositionBuilder setCommitment(FacilityCommitment commitment);
		FacilityPosition.FacilityPositionBuilder setPriorCommitment(FacilityCommitment priorCommitment);
		FacilityPosition.FacilityPositionBuilder addOutstandingsPosition(OutstandingsPosition outstandingsPosition);
		FacilityPosition.FacilityPositionBuilder addOutstandingsPosition(OutstandingsPosition outstandingsPosition, int idx);
		FacilityPosition.FacilityPositionBuilder addOutstandingsPosition(List<? extends OutstandingsPosition> outstandingsPosition);
		FacilityPosition.FacilityPositionBuilder setOutstandingsPosition(List<? extends OutstandingsPosition> outstandingsPosition);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("facilityReference"), processor, FacilityReference.FacilityReferenceBuilder.class, getFacilityReference());
			processRosetta(path.newSubPath("commitment"), processor, FacilityCommitment.FacilityCommitmentBuilder.class, getCommitment());
			processRosetta(path.newSubPath("priorCommitment"), processor, FacilityCommitment.FacilityCommitmentBuilder.class, getPriorCommitment());
			processRosetta(path.newSubPath("outstandingsPosition"), processor, OutstandingsPosition.OutstandingsPositionBuilder.class, getOutstandingsPosition());
		}
		

		FacilityPosition.FacilityPositionBuilder prune();
	}

	/*********************** Immutable Implementation of FacilityPosition  ***********************/
	class FacilityPositionImpl implements FacilityPosition {
		private final FacilityReference facilityReference;
		private final FacilityCommitment commitment;
		private final FacilityCommitment priorCommitment;
		private final List<? extends OutstandingsPosition> outstandingsPosition;
		
		protected FacilityPositionImpl(FacilityPosition.FacilityPositionBuilder builder) {
			this.facilityReference = ofNullable(builder.getFacilityReference()).map(f->f.build()).orElse(null);
			this.commitment = ofNullable(builder.getCommitment()).map(f->f.build()).orElse(null);
			this.priorCommitment = ofNullable(builder.getPriorCommitment()).map(f->f.build()).orElse(null);
			this.outstandingsPosition = ofNullable(builder.getOutstandingsPosition()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("facilityReference")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("facilityReference")
		public FacilityReference getFacilityReference() {
			return facilityReference;
		}
		
		@Override
		@RosettaAttribute("commitment")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("commitment")
		public FacilityCommitment getCommitment() {
			return commitment;
		}
		
		@Override
		@RosettaAttribute("priorCommitment")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("priorCommitment")
		public FacilityCommitment getPriorCommitment() {
			return priorCommitment;
		}
		
		@Override
		@RosettaAttribute("outstandingsPosition")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("outstandingsPosition")
		public List<? extends OutstandingsPosition> getOutstandingsPosition() {
			return outstandingsPosition;
		}
		
		@Override
		public FacilityPosition build() {
			return this;
		}
		
		@Override
		public FacilityPosition.FacilityPositionBuilder toBuilder() {
			FacilityPosition.FacilityPositionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FacilityPosition.FacilityPositionBuilder builder) {
			ofNullable(getFacilityReference()).ifPresent(builder::setFacilityReference);
			ofNullable(getCommitment()).ifPresent(builder::setCommitment);
			ofNullable(getPriorCommitment()).ifPresent(builder::setPriorCommitment);
			ofNullable(getOutstandingsPosition()).ifPresent(builder::setOutstandingsPosition);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FacilityPosition _that = getType().cast(o);
		
			if (!Objects.equals(facilityReference, _that.getFacilityReference())) return false;
			if (!Objects.equals(commitment, _that.getCommitment())) return false;
			if (!Objects.equals(priorCommitment, _that.getPriorCommitment())) return false;
			if (!ListEquals.listEquals(outstandingsPosition, _that.getOutstandingsPosition())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (facilityReference != null ? facilityReference.hashCode() : 0);
			_result = 31 * _result + (commitment != null ? commitment.hashCode() : 0);
			_result = 31 * _result + (priorCommitment != null ? priorCommitment.hashCode() : 0);
			_result = 31 * _result + (outstandingsPosition != null ? outstandingsPosition.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FacilityPosition {" +
				"facilityReference=" + this.facilityReference + ", " +
				"commitment=" + this.commitment + ", " +
				"priorCommitment=" + this.priorCommitment + ", " +
				"outstandingsPosition=" + this.outstandingsPosition +
			'}';
		}
	}

	/*********************** Builder Implementation of FacilityPosition  ***********************/
	class FacilityPositionBuilderImpl implements FacilityPosition.FacilityPositionBuilder {
	
		protected FacilityReference.FacilityReferenceBuilder facilityReference;
		protected FacilityCommitment.FacilityCommitmentBuilder commitment;
		protected FacilityCommitment.FacilityCommitmentBuilder priorCommitment;
		protected List<OutstandingsPosition.OutstandingsPositionBuilder> outstandingsPosition = new ArrayList<>();
		
		@Override
		@RosettaAttribute("facilityReference")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("facilityReference")
		public FacilityReference.FacilityReferenceBuilder getFacilityReference() {
			return facilityReference;
		}
		
		@Override
		public FacilityReference.FacilityReferenceBuilder getOrCreateFacilityReference() {
			FacilityReference.FacilityReferenceBuilder result;
			if (facilityReference!=null) {
				result = facilityReference;
			}
			else {
				result = facilityReference = FacilityReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("commitment")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("commitment")
		public FacilityCommitment.FacilityCommitmentBuilder getCommitment() {
			return commitment;
		}
		
		@Override
		public FacilityCommitment.FacilityCommitmentBuilder getOrCreateCommitment() {
			FacilityCommitment.FacilityCommitmentBuilder result;
			if (commitment!=null) {
				result = commitment;
			}
			else {
				result = commitment = FacilityCommitment.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("priorCommitment")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("priorCommitment")
		public FacilityCommitment.FacilityCommitmentBuilder getPriorCommitment() {
			return priorCommitment;
		}
		
		@Override
		public FacilityCommitment.FacilityCommitmentBuilder getOrCreatePriorCommitment() {
			FacilityCommitment.FacilityCommitmentBuilder result;
			if (priorCommitment!=null) {
				result = priorCommitment;
			}
			else {
				result = priorCommitment = FacilityCommitment.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("outstandingsPosition")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("outstandingsPosition")
		public List<? extends OutstandingsPosition.OutstandingsPositionBuilder> getOutstandingsPosition() {
			return outstandingsPosition;
		}
		
		@Override
		public OutstandingsPosition.OutstandingsPositionBuilder getOrCreateOutstandingsPosition(int index) {
			if (outstandingsPosition==null) {
				this.outstandingsPosition = new ArrayList<>();
			}
			return getIndex(outstandingsPosition, index, () -> {
						OutstandingsPosition.OutstandingsPositionBuilder newOutstandingsPosition = OutstandingsPosition.builder();
						return newOutstandingsPosition;
					});
		}
		
		@RosettaAttribute("facilityReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("facilityReference")
		@Override
		public FacilityPosition.FacilityPositionBuilder setFacilityReference(FacilityReference _facilityReference) {
			this.facilityReference = _facilityReference == null ? null : _facilityReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("commitment")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("commitment")
		@Override
		public FacilityPosition.FacilityPositionBuilder setCommitment(FacilityCommitment _commitment) {
			this.commitment = _commitment == null ? null : _commitment.toBuilder();
			return this;
		}
		
		@RosettaAttribute("priorCommitment")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("priorCommitment")
		@Override
		public FacilityPosition.FacilityPositionBuilder setPriorCommitment(FacilityCommitment _priorCommitment) {
			this.priorCommitment = _priorCommitment == null ? null : _priorCommitment.toBuilder();
			return this;
		}
		
		@RosettaAttribute("outstandingsPosition")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("outstandingsPosition")
		@Override
		public FacilityPosition.FacilityPositionBuilder addOutstandingsPosition(OutstandingsPosition _outstandingsPosition) {
			if (_outstandingsPosition != null) {
				this.outstandingsPosition.add(_outstandingsPosition.toBuilder());
			}
			return this;
		}
		
		@Override
		public FacilityPosition.FacilityPositionBuilder addOutstandingsPosition(OutstandingsPosition _outstandingsPosition, int idx) {
			getIndex(this.outstandingsPosition, idx, () -> _outstandingsPosition.toBuilder());
			return this;
		}
		
		@Override
		public FacilityPosition.FacilityPositionBuilder addOutstandingsPosition(List<? extends OutstandingsPosition> outstandingsPositions) {
			if (outstandingsPositions != null) {
				for (final OutstandingsPosition toAdd : outstandingsPositions) {
					this.outstandingsPosition.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("outstandingsPosition")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("outstandingsPosition")
		@Override
		public FacilityPosition.FacilityPositionBuilder setOutstandingsPosition(List<? extends OutstandingsPosition> outstandingsPositions) {
			if (outstandingsPositions == null) {
				this.outstandingsPosition = new ArrayList<>();
			} else {
				this.outstandingsPosition = outstandingsPositions.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public FacilityPosition build() {
			return new FacilityPosition.FacilityPositionImpl(this);
		}
		
		@Override
		public FacilityPosition.FacilityPositionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FacilityPosition.FacilityPositionBuilder prune() {
			if (facilityReference!=null && !facilityReference.prune().hasData()) facilityReference = null;
			if (commitment!=null && !commitment.prune().hasData()) commitment = null;
			if (priorCommitment!=null && !priorCommitment.prune().hasData()) priorCommitment = null;
			outstandingsPosition = outstandingsPosition.stream().filter(b->b!=null).<OutstandingsPosition.OutstandingsPositionBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getFacilityReference()!=null && getFacilityReference().hasData()) return true;
			if (getCommitment()!=null && getCommitment().hasData()) return true;
			if (getPriorCommitment()!=null && getPriorCommitment().hasData()) return true;
			if (getOutstandingsPosition()!=null && getOutstandingsPosition().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FacilityPosition.FacilityPositionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FacilityPosition.FacilityPositionBuilder o = (FacilityPosition.FacilityPositionBuilder) other;
			
			merger.mergeRosetta(getFacilityReference(), o.getFacilityReference(), this::setFacilityReference);
			merger.mergeRosetta(getCommitment(), o.getCommitment(), this::setCommitment);
			merger.mergeRosetta(getPriorCommitment(), o.getPriorCommitment(), this::setPriorCommitment);
			merger.mergeRosetta(getOutstandingsPosition(), o.getOutstandingsPosition(), this::getOrCreateOutstandingsPosition);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FacilityPosition _that = getType().cast(o);
		
			if (!Objects.equals(facilityReference, _that.getFacilityReference())) return false;
			if (!Objects.equals(commitment, _that.getCommitment())) return false;
			if (!Objects.equals(priorCommitment, _that.getPriorCommitment())) return false;
			if (!ListEquals.listEquals(outstandingsPosition, _that.getOutstandingsPosition())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (facilityReference != null ? facilityReference.hashCode() : 0);
			_result = 31 * _result + (commitment != null ? commitment.hashCode() : 0);
			_result = 31 * _result + (priorCommitment != null ? priorCommitment.hashCode() : 0);
			_result = 31 * _result + (outstandingsPosition != null ? outstandingsPosition.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FacilityPositionBuilder {" +
				"facilityReference=" + this.facilityReference + ", " +
				"commitment=" + this.commitment + ", " +
				"priorCommitment=" + this.priorCommitment + ", " +
				"outstandingsPosition=" + this.outstandingsPosition +
			'}';
		}
	}
}
