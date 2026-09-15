package iso20022.auth108.iso;

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
import iso20022.auth108.iso.meta.FinancialInstitutionSector1Meta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * Provides detailed information concerning financial counterparties.
 * @version ${project.version}
 */
@RosettaDataType(value="FinancialInstitutionSector1", builder=FinancialInstitutionSector1.FinancialInstitutionSector1BuilderImpl.class, version="${project.version}")
@RuneDataType(value="FinancialInstitutionSector1", model="iso20022", builder=FinancialInstitutionSector1.FinancialInstitutionSector1BuilderImpl.class, version="${project.version}")
public interface FinancialInstitutionSector1 extends RosettaModelObject {

	FinancialInstitutionSector1Meta metaData = new FinancialInstitutionSector1Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Specifies the nature of the counterparty business activities.
	 */
	List<? extends FinancialPartyClassification2Choice> getSctr();
	/**
	 * Information whether the counterparty is above the clearing threshold.    Usage: If the element is not present, the ClearingThreshold is False.
	 */
	Boolean getClrThrshld();

	/*********************** Build Methods  ***********************/
	FinancialInstitutionSector1 build();
	
	FinancialInstitutionSector1.FinancialInstitutionSector1Builder toBuilder();
	
	static FinancialInstitutionSector1.FinancialInstitutionSector1Builder builder() {
		return new FinancialInstitutionSector1.FinancialInstitutionSector1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FinancialInstitutionSector1> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FinancialInstitutionSector1> getType() {
		return FinancialInstitutionSector1.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("sctr"), processor, FinancialPartyClassification2Choice.class, getSctr());
		processor.processBasic(path.newSubPath("clrThrshld"), Boolean.class, getClrThrshld(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface FinancialInstitutionSector1Builder extends FinancialInstitutionSector1, RosettaModelObjectBuilder {
		FinancialPartyClassification2Choice.FinancialPartyClassification2ChoiceBuilder getOrCreateSctr(int index);
		@Override
		List<? extends FinancialPartyClassification2Choice.FinancialPartyClassification2ChoiceBuilder> getSctr();
		FinancialInstitutionSector1.FinancialInstitutionSector1Builder addSctr(FinancialPartyClassification2Choice sctr);
		FinancialInstitutionSector1.FinancialInstitutionSector1Builder addSctr(FinancialPartyClassification2Choice sctr, int idx);
		FinancialInstitutionSector1.FinancialInstitutionSector1Builder addSctr(List<? extends FinancialPartyClassification2Choice> sctr);
		FinancialInstitutionSector1.FinancialInstitutionSector1Builder setSctr(List<? extends FinancialPartyClassification2Choice> sctr);
		FinancialInstitutionSector1.FinancialInstitutionSector1Builder setClrThrshld(Boolean clrThrshld);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("sctr"), processor, FinancialPartyClassification2Choice.FinancialPartyClassification2ChoiceBuilder.class, getSctr());
			processor.processBasic(path.newSubPath("clrThrshld"), Boolean.class, getClrThrshld(), this);
		}
		

		FinancialInstitutionSector1.FinancialInstitutionSector1Builder prune();
	}

	/*********************** Immutable Implementation of FinancialInstitutionSector1  ***********************/
	class FinancialInstitutionSector1Impl implements FinancialInstitutionSector1 {
		private final List<? extends FinancialPartyClassification2Choice> sctr;
		private final Boolean clrThrshld;
		
		protected FinancialInstitutionSector1Impl(FinancialInstitutionSector1.FinancialInstitutionSector1Builder builder) {
			this.sctr = ofNullable(builder.getSctr()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.clrThrshld = builder.getClrThrshld();
		}
		
		@Override
		@RosettaAttribute("sctr")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("sctr")
		public List<? extends FinancialPartyClassification2Choice> getSctr() {
			return sctr;
		}
		
		@Override
		@RosettaAttribute("clrThrshld")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("clrThrshld")
		public Boolean getClrThrshld() {
			return clrThrshld;
		}
		
		@Override
		public FinancialInstitutionSector1 build() {
			return this;
		}
		
		@Override
		public FinancialInstitutionSector1.FinancialInstitutionSector1Builder toBuilder() {
			FinancialInstitutionSector1.FinancialInstitutionSector1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FinancialInstitutionSector1.FinancialInstitutionSector1Builder builder) {
			ofNullable(getSctr()).ifPresent(builder::setSctr);
			ofNullable(getClrThrshld()).ifPresent(builder::setClrThrshld);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FinancialInstitutionSector1 _that = getType().cast(o);
		
			if (!ListEquals.listEquals(sctr, _that.getSctr())) return false;
			if (!Objects.equals(clrThrshld, _that.getClrThrshld())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (sctr != null ? sctr.hashCode() : 0);
			_result = 31 * _result + (clrThrshld != null ? clrThrshld.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FinancialInstitutionSector1 {" +
				"sctr=" + this.sctr + ", " +
				"clrThrshld=" + this.clrThrshld +
			'}';
		}
	}

	/*********************** Builder Implementation of FinancialInstitutionSector1  ***********************/
	class FinancialInstitutionSector1BuilderImpl implements FinancialInstitutionSector1.FinancialInstitutionSector1Builder {
	
		protected List<FinancialPartyClassification2Choice.FinancialPartyClassification2ChoiceBuilder> sctr = new ArrayList<>();
		protected Boolean clrThrshld;
		
		@Override
		@RosettaAttribute("sctr")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("sctr")
		public List<? extends FinancialPartyClassification2Choice.FinancialPartyClassification2ChoiceBuilder> getSctr() {
			return sctr;
		}
		
		@Override
		public FinancialPartyClassification2Choice.FinancialPartyClassification2ChoiceBuilder getOrCreateSctr(int index) {
			if (sctr==null) {
				this.sctr = new ArrayList<>();
			}
			return getIndex(sctr, index, () -> {
						FinancialPartyClassification2Choice.FinancialPartyClassification2ChoiceBuilder newSctr = FinancialPartyClassification2Choice.builder();
						return newSctr;
					});
		}
		
		@Override
		@RosettaAttribute("clrThrshld")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("clrThrshld")
		public Boolean getClrThrshld() {
			return clrThrshld;
		}
		
		@RosettaAttribute("sctr")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("sctr")
		@Override
		public FinancialInstitutionSector1.FinancialInstitutionSector1Builder addSctr(FinancialPartyClassification2Choice _sctr) {
			if (_sctr != null) {
				this.sctr.add(_sctr.toBuilder());
			}
			return this;
		}
		
		@Override
		public FinancialInstitutionSector1.FinancialInstitutionSector1Builder addSctr(FinancialPartyClassification2Choice _sctr, int idx) {
			getIndex(this.sctr, idx, () -> _sctr.toBuilder());
			return this;
		}
		
		@Override
		public FinancialInstitutionSector1.FinancialInstitutionSector1Builder addSctr(List<? extends FinancialPartyClassification2Choice> sctrs) {
			if (sctrs != null) {
				for (final FinancialPartyClassification2Choice toAdd : sctrs) {
					this.sctr.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("sctr")
		@Accessor(AccessorType.SETTER)
		@Required
		@Multi
		@RuneAttribute("sctr")
		@Override
		public FinancialInstitutionSector1.FinancialInstitutionSector1Builder setSctr(List<? extends FinancialPartyClassification2Choice> sctrs) {
			if (sctrs == null) {
				this.sctr = new ArrayList<>();
			} else {
				this.sctr = sctrs.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("clrThrshld")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("clrThrshld")
		@Override
		public FinancialInstitutionSector1.FinancialInstitutionSector1Builder setClrThrshld(Boolean _clrThrshld) {
			this.clrThrshld = _clrThrshld == null ? null : _clrThrshld;
			return this;
		}
		
		@Override
		public FinancialInstitutionSector1 build() {
			return new FinancialInstitutionSector1.FinancialInstitutionSector1Impl(this);
		}
		
		@Override
		public FinancialInstitutionSector1.FinancialInstitutionSector1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FinancialInstitutionSector1.FinancialInstitutionSector1Builder prune() {
			sctr = sctr.stream().filter(b->b!=null).<FinancialPartyClassification2Choice.FinancialPartyClassification2ChoiceBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getSctr()!=null && getSctr().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getClrThrshld()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FinancialInstitutionSector1.FinancialInstitutionSector1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FinancialInstitutionSector1.FinancialInstitutionSector1Builder o = (FinancialInstitutionSector1.FinancialInstitutionSector1Builder) other;
			
			merger.mergeRosetta(getSctr(), o.getSctr(), this::getOrCreateSctr);
			
			merger.mergeBasic(getClrThrshld(), o.getClrThrshld(), this::setClrThrshld);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FinancialInstitutionSector1 _that = getType().cast(o);
		
			if (!ListEquals.listEquals(sctr, _that.getSctr())) return false;
			if (!Objects.equals(clrThrshld, _that.getClrThrshld())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (sctr != null ? sctr.hashCode() : 0);
			_result = 31 * _result + (clrThrshld != null ? clrThrshld.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FinancialInstitutionSector1Builder {" +
				"sctr=" + this.sctr + ", " +
				"clrThrshld=" + this.clrThrshld +
			'}';
		}
	}
}
