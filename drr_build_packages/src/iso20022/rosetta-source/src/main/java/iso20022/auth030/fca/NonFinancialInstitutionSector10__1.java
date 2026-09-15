package iso20022.auth030.fca;

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
import iso20022.auth030.fca.meta.NonFinancialInstitutionSector10__1Meta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * Provides detailed information concerning non financial counterparties.
 * @version ${project.version}
 */
@RosettaDataType(value="NonFinancialInstitutionSector10__1", builder=NonFinancialInstitutionSector10__1.NonFinancialInstitutionSector10__1BuilderImpl.class, version="${project.version}")
@RuneDataType(value="NonFinancialInstitutionSector10__1", model="iso20022", builder=NonFinancialInstitutionSector10__1.NonFinancialInstitutionSector10__1BuilderImpl.class, version="${project.version}")
public interface NonFinancialInstitutionSector10__1 extends RosettaModelObject {

	NonFinancialInstitutionSector10__1Meta metaData = new NonFinancialInstitutionSector10__1Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Taxonomy for non-financial counterparties. The categories correspond to the main sections of NACE classification as defined in the regulation.
	 */
	List<? extends GenericIdentification175__1> getSctr();
	/**
	 * Information whether the counterparty is above the clearing threshold.  Usage: If the element is not present, the ClearingThreshold is False.
	 */
	Boolean getClrThrshld();
	/**
	 * Directly linked to commercial activity or treasury financing: Information on whether the contract is objectively measurable as directly linked to the counterparty&#39;s commercial or treasury financing activity.  Usage: If the element is not present, the DirectlyLinkedActivity is False.
	 */
	Boolean getDrctlyLkdActvty();

	/*********************** Build Methods  ***********************/
	NonFinancialInstitutionSector10__1 build();
	
	NonFinancialInstitutionSector10__1.NonFinancialInstitutionSector10__1Builder toBuilder();
	
	static NonFinancialInstitutionSector10__1.NonFinancialInstitutionSector10__1Builder builder() {
		return new NonFinancialInstitutionSector10__1.NonFinancialInstitutionSector10__1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends NonFinancialInstitutionSector10__1> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends NonFinancialInstitutionSector10__1> getType() {
		return NonFinancialInstitutionSector10__1.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("sctr"), processor, GenericIdentification175__1.class, getSctr());
		processor.processBasic(path.newSubPath("clrThrshld"), Boolean.class, getClrThrshld(), this);
		processor.processBasic(path.newSubPath("drctlyLkdActvty"), Boolean.class, getDrctlyLkdActvty(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface NonFinancialInstitutionSector10__1Builder extends NonFinancialInstitutionSector10__1, RosettaModelObjectBuilder {
		GenericIdentification175__1.GenericIdentification175__1Builder getOrCreateSctr(int index);
		@Override
		List<? extends GenericIdentification175__1.GenericIdentification175__1Builder> getSctr();
		NonFinancialInstitutionSector10__1.NonFinancialInstitutionSector10__1Builder addSctr(GenericIdentification175__1 sctr);
		NonFinancialInstitutionSector10__1.NonFinancialInstitutionSector10__1Builder addSctr(GenericIdentification175__1 sctr, int idx);
		NonFinancialInstitutionSector10__1.NonFinancialInstitutionSector10__1Builder addSctr(List<? extends GenericIdentification175__1> sctr);
		NonFinancialInstitutionSector10__1.NonFinancialInstitutionSector10__1Builder setSctr(List<? extends GenericIdentification175__1> sctr);
		NonFinancialInstitutionSector10__1.NonFinancialInstitutionSector10__1Builder setClrThrshld(Boolean clrThrshld);
		NonFinancialInstitutionSector10__1.NonFinancialInstitutionSector10__1Builder setDrctlyLkdActvty(Boolean drctlyLkdActvty);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("sctr"), processor, GenericIdentification175__1.GenericIdentification175__1Builder.class, getSctr());
			processor.processBasic(path.newSubPath("clrThrshld"), Boolean.class, getClrThrshld(), this);
			processor.processBasic(path.newSubPath("drctlyLkdActvty"), Boolean.class, getDrctlyLkdActvty(), this);
		}
		

		NonFinancialInstitutionSector10__1.NonFinancialInstitutionSector10__1Builder prune();
	}

	/*********************** Immutable Implementation of NonFinancialInstitutionSector10__1  ***********************/
	class NonFinancialInstitutionSector10__1Impl implements NonFinancialInstitutionSector10__1 {
		private final List<? extends GenericIdentification175__1> sctr;
		private final Boolean clrThrshld;
		private final Boolean drctlyLkdActvty;
		
		protected NonFinancialInstitutionSector10__1Impl(NonFinancialInstitutionSector10__1.NonFinancialInstitutionSector10__1Builder builder) {
			this.sctr = ofNullable(builder.getSctr()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.clrThrshld = builder.getClrThrshld();
			this.drctlyLkdActvty = builder.getDrctlyLkdActvty();
		}
		
		@Override
		@RosettaAttribute("sctr")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("sctr")
		public List<? extends GenericIdentification175__1> getSctr() {
			return sctr;
		}
		
		@Override
		@RosettaAttribute("clrThrshld")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("clrThrshld")
		public Boolean getClrThrshld() {
			return clrThrshld;
		}
		
		@Override
		@RosettaAttribute("drctlyLkdActvty")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("drctlyLkdActvty")
		public Boolean getDrctlyLkdActvty() {
			return drctlyLkdActvty;
		}
		
		@Override
		public NonFinancialInstitutionSector10__1 build() {
			return this;
		}
		
		@Override
		public NonFinancialInstitutionSector10__1.NonFinancialInstitutionSector10__1Builder toBuilder() {
			NonFinancialInstitutionSector10__1.NonFinancialInstitutionSector10__1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(NonFinancialInstitutionSector10__1.NonFinancialInstitutionSector10__1Builder builder) {
			ofNullable(getSctr()).ifPresent(builder::setSctr);
			ofNullable(getClrThrshld()).ifPresent(builder::setClrThrshld);
			ofNullable(getDrctlyLkdActvty()).ifPresent(builder::setDrctlyLkdActvty);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			NonFinancialInstitutionSector10__1 _that = getType().cast(o);
		
			if (!ListEquals.listEquals(sctr, _that.getSctr())) return false;
			if (!Objects.equals(clrThrshld, _that.getClrThrshld())) return false;
			if (!Objects.equals(drctlyLkdActvty, _that.getDrctlyLkdActvty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (sctr != null ? sctr.hashCode() : 0);
			_result = 31 * _result + (clrThrshld != null ? clrThrshld.hashCode() : 0);
			_result = 31 * _result + (drctlyLkdActvty != null ? drctlyLkdActvty.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "NonFinancialInstitutionSector10__1 {" +
				"sctr=" + this.sctr + ", " +
				"clrThrshld=" + this.clrThrshld + ", " +
				"drctlyLkdActvty=" + this.drctlyLkdActvty +
			'}';
		}
	}

	/*********************** Builder Implementation of NonFinancialInstitutionSector10__1  ***********************/
	class NonFinancialInstitutionSector10__1BuilderImpl implements NonFinancialInstitutionSector10__1.NonFinancialInstitutionSector10__1Builder {
	
		protected List<GenericIdentification175__1.GenericIdentification175__1Builder> sctr = new ArrayList<>();
		protected Boolean clrThrshld;
		protected Boolean drctlyLkdActvty;
		
		@Override
		@RosettaAttribute("sctr")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("sctr")
		public List<? extends GenericIdentification175__1.GenericIdentification175__1Builder> getSctr() {
			return sctr;
		}
		
		@Override
		public GenericIdentification175__1.GenericIdentification175__1Builder getOrCreateSctr(int index) {
			if (sctr==null) {
				this.sctr = new ArrayList<>();
			}
			return getIndex(sctr, index, () -> {
						GenericIdentification175__1.GenericIdentification175__1Builder newSctr = GenericIdentification175__1.builder();
						return newSctr;
					});
		}
		
		@Override
		@RosettaAttribute("clrThrshld")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("clrThrshld")
		public Boolean getClrThrshld() {
			return clrThrshld;
		}
		
		@Override
		@RosettaAttribute("drctlyLkdActvty")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("drctlyLkdActvty")
		public Boolean getDrctlyLkdActvty() {
			return drctlyLkdActvty;
		}
		
		@RosettaAttribute("sctr")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("sctr")
		@Override
		public NonFinancialInstitutionSector10__1.NonFinancialInstitutionSector10__1Builder addSctr(GenericIdentification175__1 _sctr) {
			if (_sctr != null) {
				this.sctr.add(_sctr.toBuilder());
			}
			return this;
		}
		
		@Override
		public NonFinancialInstitutionSector10__1.NonFinancialInstitutionSector10__1Builder addSctr(GenericIdentification175__1 _sctr, int idx) {
			getIndex(this.sctr, idx, () -> _sctr.toBuilder());
			return this;
		}
		
		@Override
		public NonFinancialInstitutionSector10__1.NonFinancialInstitutionSector10__1Builder addSctr(List<? extends GenericIdentification175__1> sctrs) {
			if (sctrs != null) {
				for (final GenericIdentification175__1 toAdd : sctrs) {
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
		public NonFinancialInstitutionSector10__1.NonFinancialInstitutionSector10__1Builder setSctr(List<? extends GenericIdentification175__1> sctrs) {
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
		@Required
		@RuneAttribute("clrThrshld")
		@Override
		public NonFinancialInstitutionSector10__1.NonFinancialInstitutionSector10__1Builder setClrThrshld(Boolean _clrThrshld) {
			this.clrThrshld = _clrThrshld == null ? null : _clrThrshld;
			return this;
		}
		
		@RosettaAttribute("drctlyLkdActvty")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("drctlyLkdActvty")
		@Override
		public NonFinancialInstitutionSector10__1.NonFinancialInstitutionSector10__1Builder setDrctlyLkdActvty(Boolean _drctlyLkdActvty) {
			this.drctlyLkdActvty = _drctlyLkdActvty == null ? null : _drctlyLkdActvty;
			return this;
		}
		
		@Override
		public NonFinancialInstitutionSector10__1 build() {
			return new NonFinancialInstitutionSector10__1.NonFinancialInstitutionSector10__1Impl(this);
		}
		
		@Override
		public NonFinancialInstitutionSector10__1.NonFinancialInstitutionSector10__1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NonFinancialInstitutionSector10__1.NonFinancialInstitutionSector10__1Builder prune() {
			sctr = sctr.stream().filter(b->b!=null).<GenericIdentification175__1.GenericIdentification175__1Builder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getSctr()!=null && getSctr().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getClrThrshld()!=null) return true;
			if (getDrctlyLkdActvty()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NonFinancialInstitutionSector10__1.NonFinancialInstitutionSector10__1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			NonFinancialInstitutionSector10__1.NonFinancialInstitutionSector10__1Builder o = (NonFinancialInstitutionSector10__1.NonFinancialInstitutionSector10__1Builder) other;
			
			merger.mergeRosetta(getSctr(), o.getSctr(), this::getOrCreateSctr);
			
			merger.mergeBasic(getClrThrshld(), o.getClrThrshld(), this::setClrThrshld);
			merger.mergeBasic(getDrctlyLkdActvty(), o.getDrctlyLkdActvty(), this::setDrctlyLkdActvty);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			NonFinancialInstitutionSector10__1 _that = getType().cast(o);
		
			if (!ListEquals.listEquals(sctr, _that.getSctr())) return false;
			if (!Objects.equals(clrThrshld, _that.getClrThrshld())) return false;
			if (!Objects.equals(drctlyLkdActvty, _that.getDrctlyLkdActvty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (sctr != null ? sctr.hashCode() : 0);
			_result = 31 * _result + (clrThrshld != null ? clrThrshld.hashCode() : 0);
			_result = 31 * _result + (drctlyLkdActvty != null ? drctlyLkdActvty.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "NonFinancialInstitutionSector10__1Builder {" +
				"sctr=" + this.sctr + ", " +
				"clrThrshld=" + this.clrThrshld + ", " +
				"drctlyLkdActvty=" + this.drctlyLkdActvty +
			'}';
		}
	}
}
