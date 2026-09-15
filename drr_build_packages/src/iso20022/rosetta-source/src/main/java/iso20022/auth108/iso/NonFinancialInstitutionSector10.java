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
import iso20022.auth108.iso.meta.NonFinancialInstitutionSector10Meta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * Provides detailed information concerning non financial counterparties.
 * @version ${project.version}
 */
@RosettaDataType(value="NonFinancialInstitutionSector10", builder=NonFinancialInstitutionSector10.NonFinancialInstitutionSector10BuilderImpl.class, version="${project.version}")
@RuneDataType(value="NonFinancialInstitutionSector10", model="iso20022", builder=NonFinancialInstitutionSector10.NonFinancialInstitutionSector10BuilderImpl.class, version="${project.version}")
public interface NonFinancialInstitutionSector10 extends RosettaModelObject {

	NonFinancialInstitutionSector10Meta metaData = new NonFinancialInstitutionSector10Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Taxonomy for non-financial counterparties. The categories correspond to the main sections of NACE classification as defined in the regulation.
	 */
	List<? extends GenericIdentification175> getSctr();
	/**
	 * Information whether the counterparty is above the clearing threshold.    Usage: If the element is not present, the ClearingThreshold is False.
	 */
	Boolean getClrThrshld();
	/**
	 * Directly linked to commercial activity or treasury financing: Information on whether the contract is objectively measurable as directly linked to the counterparty&#39;s commercial or treasury financing activity.    Usage: If the element is not present, the DirectlyLinkedActivity is False.
	 */
	Boolean getDrctlyLkdActvty();
	/**
	 * Indicates whether the counterparty is an entity established pursuant to federal law like for example a federal authority or a government corporation.    Usage: If the element is not present, the FederalInstitution is False.
	 */
	Boolean getFdrlInstn();

	/*********************** Build Methods  ***********************/
	NonFinancialInstitutionSector10 build();
	
	NonFinancialInstitutionSector10.NonFinancialInstitutionSector10Builder toBuilder();
	
	static NonFinancialInstitutionSector10.NonFinancialInstitutionSector10Builder builder() {
		return new NonFinancialInstitutionSector10.NonFinancialInstitutionSector10BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends NonFinancialInstitutionSector10> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends NonFinancialInstitutionSector10> getType() {
		return NonFinancialInstitutionSector10.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("sctr"), processor, GenericIdentification175.class, getSctr());
		processor.processBasic(path.newSubPath("clrThrshld"), Boolean.class, getClrThrshld(), this);
		processor.processBasic(path.newSubPath("drctlyLkdActvty"), Boolean.class, getDrctlyLkdActvty(), this);
		processor.processBasic(path.newSubPath("fdrlInstn"), Boolean.class, getFdrlInstn(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface NonFinancialInstitutionSector10Builder extends NonFinancialInstitutionSector10, RosettaModelObjectBuilder {
		GenericIdentification175.GenericIdentification175Builder getOrCreateSctr(int index);
		@Override
		List<? extends GenericIdentification175.GenericIdentification175Builder> getSctr();
		NonFinancialInstitutionSector10.NonFinancialInstitutionSector10Builder addSctr(GenericIdentification175 sctr);
		NonFinancialInstitutionSector10.NonFinancialInstitutionSector10Builder addSctr(GenericIdentification175 sctr, int idx);
		NonFinancialInstitutionSector10.NonFinancialInstitutionSector10Builder addSctr(List<? extends GenericIdentification175> sctr);
		NonFinancialInstitutionSector10.NonFinancialInstitutionSector10Builder setSctr(List<? extends GenericIdentification175> sctr);
		NonFinancialInstitutionSector10.NonFinancialInstitutionSector10Builder setClrThrshld(Boolean clrThrshld);
		NonFinancialInstitutionSector10.NonFinancialInstitutionSector10Builder setDrctlyLkdActvty(Boolean drctlyLkdActvty);
		NonFinancialInstitutionSector10.NonFinancialInstitutionSector10Builder setFdrlInstn(Boolean fdrlInstn);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("sctr"), processor, GenericIdentification175.GenericIdentification175Builder.class, getSctr());
			processor.processBasic(path.newSubPath("clrThrshld"), Boolean.class, getClrThrshld(), this);
			processor.processBasic(path.newSubPath("drctlyLkdActvty"), Boolean.class, getDrctlyLkdActvty(), this);
			processor.processBasic(path.newSubPath("fdrlInstn"), Boolean.class, getFdrlInstn(), this);
		}
		

		NonFinancialInstitutionSector10.NonFinancialInstitutionSector10Builder prune();
	}

	/*********************** Immutable Implementation of NonFinancialInstitutionSector10  ***********************/
	class NonFinancialInstitutionSector10Impl implements NonFinancialInstitutionSector10 {
		private final List<? extends GenericIdentification175> sctr;
		private final Boolean clrThrshld;
		private final Boolean drctlyLkdActvty;
		private final Boolean fdrlInstn;
		
		protected NonFinancialInstitutionSector10Impl(NonFinancialInstitutionSector10.NonFinancialInstitutionSector10Builder builder) {
			this.sctr = ofNullable(builder.getSctr()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.clrThrshld = builder.getClrThrshld();
			this.drctlyLkdActvty = builder.getDrctlyLkdActvty();
			this.fdrlInstn = builder.getFdrlInstn();
		}
		
		@Override
		@RosettaAttribute("sctr")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("sctr")
		public List<? extends GenericIdentification175> getSctr() {
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
		@RosettaAttribute("drctlyLkdActvty")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("drctlyLkdActvty")
		public Boolean getDrctlyLkdActvty() {
			return drctlyLkdActvty;
		}
		
		@Override
		@RosettaAttribute("fdrlInstn")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fdrlInstn")
		public Boolean getFdrlInstn() {
			return fdrlInstn;
		}
		
		@Override
		public NonFinancialInstitutionSector10 build() {
			return this;
		}
		
		@Override
		public NonFinancialInstitutionSector10.NonFinancialInstitutionSector10Builder toBuilder() {
			NonFinancialInstitutionSector10.NonFinancialInstitutionSector10Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(NonFinancialInstitutionSector10.NonFinancialInstitutionSector10Builder builder) {
			ofNullable(getSctr()).ifPresent(builder::setSctr);
			ofNullable(getClrThrshld()).ifPresent(builder::setClrThrshld);
			ofNullable(getDrctlyLkdActvty()).ifPresent(builder::setDrctlyLkdActvty);
			ofNullable(getFdrlInstn()).ifPresent(builder::setFdrlInstn);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			NonFinancialInstitutionSector10 _that = getType().cast(o);
		
			if (!ListEquals.listEquals(sctr, _that.getSctr())) return false;
			if (!Objects.equals(clrThrshld, _that.getClrThrshld())) return false;
			if (!Objects.equals(drctlyLkdActvty, _that.getDrctlyLkdActvty())) return false;
			if (!Objects.equals(fdrlInstn, _that.getFdrlInstn())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (sctr != null ? sctr.hashCode() : 0);
			_result = 31 * _result + (clrThrshld != null ? clrThrshld.hashCode() : 0);
			_result = 31 * _result + (drctlyLkdActvty != null ? drctlyLkdActvty.hashCode() : 0);
			_result = 31 * _result + (fdrlInstn != null ? fdrlInstn.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "NonFinancialInstitutionSector10 {" +
				"sctr=" + this.sctr + ", " +
				"clrThrshld=" + this.clrThrshld + ", " +
				"drctlyLkdActvty=" + this.drctlyLkdActvty + ", " +
				"fdrlInstn=" + this.fdrlInstn +
			'}';
		}
	}

	/*********************** Builder Implementation of NonFinancialInstitutionSector10  ***********************/
	class NonFinancialInstitutionSector10BuilderImpl implements NonFinancialInstitutionSector10.NonFinancialInstitutionSector10Builder {
	
		protected List<GenericIdentification175.GenericIdentification175Builder> sctr = new ArrayList<>();
		protected Boolean clrThrshld;
		protected Boolean drctlyLkdActvty;
		protected Boolean fdrlInstn;
		
		@Override
		@RosettaAttribute("sctr")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("sctr")
		public List<? extends GenericIdentification175.GenericIdentification175Builder> getSctr() {
			return sctr;
		}
		
		@Override
		public GenericIdentification175.GenericIdentification175Builder getOrCreateSctr(int index) {
			if (sctr==null) {
				this.sctr = new ArrayList<>();
			}
			return getIndex(sctr, index, () -> {
						GenericIdentification175.GenericIdentification175Builder newSctr = GenericIdentification175.builder();
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
		
		@Override
		@RosettaAttribute("drctlyLkdActvty")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("drctlyLkdActvty")
		public Boolean getDrctlyLkdActvty() {
			return drctlyLkdActvty;
		}
		
		@Override
		@RosettaAttribute("fdrlInstn")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fdrlInstn")
		public Boolean getFdrlInstn() {
			return fdrlInstn;
		}
		
		@RosettaAttribute("sctr")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("sctr")
		@Override
		public NonFinancialInstitutionSector10.NonFinancialInstitutionSector10Builder addSctr(GenericIdentification175 _sctr) {
			if (_sctr != null) {
				this.sctr.add(_sctr.toBuilder());
			}
			return this;
		}
		
		@Override
		public NonFinancialInstitutionSector10.NonFinancialInstitutionSector10Builder addSctr(GenericIdentification175 _sctr, int idx) {
			getIndex(this.sctr, idx, () -> _sctr.toBuilder());
			return this;
		}
		
		@Override
		public NonFinancialInstitutionSector10.NonFinancialInstitutionSector10Builder addSctr(List<? extends GenericIdentification175> sctrs) {
			if (sctrs != null) {
				for (final GenericIdentification175 toAdd : sctrs) {
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
		public NonFinancialInstitutionSector10.NonFinancialInstitutionSector10Builder setSctr(List<? extends GenericIdentification175> sctrs) {
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
		public NonFinancialInstitutionSector10.NonFinancialInstitutionSector10Builder setClrThrshld(Boolean _clrThrshld) {
			this.clrThrshld = _clrThrshld == null ? null : _clrThrshld;
			return this;
		}
		
		@RosettaAttribute("drctlyLkdActvty")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("drctlyLkdActvty")
		@Override
		public NonFinancialInstitutionSector10.NonFinancialInstitutionSector10Builder setDrctlyLkdActvty(Boolean _drctlyLkdActvty) {
			this.drctlyLkdActvty = _drctlyLkdActvty == null ? null : _drctlyLkdActvty;
			return this;
		}
		
		@RosettaAttribute("fdrlInstn")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("fdrlInstn")
		@Override
		public NonFinancialInstitutionSector10.NonFinancialInstitutionSector10Builder setFdrlInstn(Boolean _fdrlInstn) {
			this.fdrlInstn = _fdrlInstn == null ? null : _fdrlInstn;
			return this;
		}
		
		@Override
		public NonFinancialInstitutionSector10 build() {
			return new NonFinancialInstitutionSector10.NonFinancialInstitutionSector10Impl(this);
		}
		
		@Override
		public NonFinancialInstitutionSector10.NonFinancialInstitutionSector10Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NonFinancialInstitutionSector10.NonFinancialInstitutionSector10Builder prune() {
			sctr = sctr.stream().filter(b->b!=null).<GenericIdentification175.GenericIdentification175Builder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getSctr()!=null && getSctr().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getClrThrshld()!=null) return true;
			if (getDrctlyLkdActvty()!=null) return true;
			if (getFdrlInstn()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NonFinancialInstitutionSector10.NonFinancialInstitutionSector10Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			NonFinancialInstitutionSector10.NonFinancialInstitutionSector10Builder o = (NonFinancialInstitutionSector10.NonFinancialInstitutionSector10Builder) other;
			
			merger.mergeRosetta(getSctr(), o.getSctr(), this::getOrCreateSctr);
			
			merger.mergeBasic(getClrThrshld(), o.getClrThrshld(), this::setClrThrshld);
			merger.mergeBasic(getDrctlyLkdActvty(), o.getDrctlyLkdActvty(), this::setDrctlyLkdActvty);
			merger.mergeBasic(getFdrlInstn(), o.getFdrlInstn(), this::setFdrlInstn);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			NonFinancialInstitutionSector10 _that = getType().cast(o);
		
			if (!ListEquals.listEquals(sctr, _that.getSctr())) return false;
			if (!Objects.equals(clrThrshld, _that.getClrThrshld())) return false;
			if (!Objects.equals(drctlyLkdActvty, _that.getDrctlyLkdActvty())) return false;
			if (!Objects.equals(fdrlInstn, _that.getFdrlInstn())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (sctr != null ? sctr.hashCode() : 0);
			_result = 31 * _result + (clrThrshld != null ? clrThrshld.hashCode() : 0);
			_result = 31 * _result + (drctlyLkdActvty != null ? drctlyLkdActvty.hashCode() : 0);
			_result = 31 * _result + (fdrlInstn != null ? fdrlInstn.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "NonFinancialInstitutionSector10Builder {" +
				"sctr=" + this.sctr + ", " +
				"clrThrshld=" + this.clrThrshld + ", " +
				"drctlyLkdActvty=" + this.drctlyLkdActvty + ", " +
				"fdrlInstn=" + this.fdrlInstn +
			'}';
		}
	}
}
