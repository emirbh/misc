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
import iso20022.auth030.fca.meta.NonFinancialInstitutionSector10__2Meta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * Provides detailed information concerning non financial counterparties.
 * @version ${project.version}
 */
@RosettaDataType(value="NonFinancialInstitutionSector10__2", builder=NonFinancialInstitutionSector10__2.NonFinancialInstitutionSector10__2BuilderImpl.class, version="${project.version}")
@RuneDataType(value="NonFinancialInstitutionSector10__2", model="iso20022", builder=NonFinancialInstitutionSector10__2.NonFinancialInstitutionSector10__2BuilderImpl.class, version="${project.version}")
public interface NonFinancialInstitutionSector10__2 extends RosettaModelObject {

	NonFinancialInstitutionSector10__2Meta metaData = new NonFinancialInstitutionSector10__2Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Taxonomy for non-financial counterparties. The categories correspond to the main sections of NACE classification as defined in the regulation.
	 */
	List<? extends GenericIdentification175__1> getSctr();
	/**
	 * Information whether the counterparty is above the clearing threshold.  Usage: If the element is not present, the ClearingThreshold is False.
	 */
	Boolean getClrThrshld();

	/*********************** Build Methods  ***********************/
	NonFinancialInstitutionSector10__2 build();
	
	NonFinancialInstitutionSector10__2.NonFinancialInstitutionSector10__2Builder toBuilder();
	
	static NonFinancialInstitutionSector10__2.NonFinancialInstitutionSector10__2Builder builder() {
		return new NonFinancialInstitutionSector10__2.NonFinancialInstitutionSector10__2BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends NonFinancialInstitutionSector10__2> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends NonFinancialInstitutionSector10__2> getType() {
		return NonFinancialInstitutionSector10__2.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("sctr"), processor, GenericIdentification175__1.class, getSctr());
		processor.processBasic(path.newSubPath("clrThrshld"), Boolean.class, getClrThrshld(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface NonFinancialInstitutionSector10__2Builder extends NonFinancialInstitutionSector10__2, RosettaModelObjectBuilder {
		GenericIdentification175__1.GenericIdentification175__1Builder getOrCreateSctr(int index);
		@Override
		List<? extends GenericIdentification175__1.GenericIdentification175__1Builder> getSctr();
		NonFinancialInstitutionSector10__2.NonFinancialInstitutionSector10__2Builder addSctr(GenericIdentification175__1 sctr);
		NonFinancialInstitutionSector10__2.NonFinancialInstitutionSector10__2Builder addSctr(GenericIdentification175__1 sctr, int idx);
		NonFinancialInstitutionSector10__2.NonFinancialInstitutionSector10__2Builder addSctr(List<? extends GenericIdentification175__1> sctr);
		NonFinancialInstitutionSector10__2.NonFinancialInstitutionSector10__2Builder setSctr(List<? extends GenericIdentification175__1> sctr);
		NonFinancialInstitutionSector10__2.NonFinancialInstitutionSector10__2Builder setClrThrshld(Boolean clrThrshld);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("sctr"), processor, GenericIdentification175__1.GenericIdentification175__1Builder.class, getSctr());
			processor.processBasic(path.newSubPath("clrThrshld"), Boolean.class, getClrThrshld(), this);
		}
		

		NonFinancialInstitutionSector10__2.NonFinancialInstitutionSector10__2Builder prune();
	}

	/*********************** Immutable Implementation of NonFinancialInstitutionSector10__2  ***********************/
	class NonFinancialInstitutionSector10__2Impl implements NonFinancialInstitutionSector10__2 {
		private final List<? extends GenericIdentification175__1> sctr;
		private final Boolean clrThrshld;
		
		protected NonFinancialInstitutionSector10__2Impl(NonFinancialInstitutionSector10__2.NonFinancialInstitutionSector10__2Builder builder) {
			this.sctr = ofNullable(builder.getSctr()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.clrThrshld = builder.getClrThrshld();
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
		public NonFinancialInstitutionSector10__2 build() {
			return this;
		}
		
		@Override
		public NonFinancialInstitutionSector10__2.NonFinancialInstitutionSector10__2Builder toBuilder() {
			NonFinancialInstitutionSector10__2.NonFinancialInstitutionSector10__2Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(NonFinancialInstitutionSector10__2.NonFinancialInstitutionSector10__2Builder builder) {
			ofNullable(getSctr()).ifPresent(builder::setSctr);
			ofNullable(getClrThrshld()).ifPresent(builder::setClrThrshld);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			NonFinancialInstitutionSector10__2 _that = getType().cast(o);
		
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
			return "NonFinancialInstitutionSector10__2 {" +
				"sctr=" + this.sctr + ", " +
				"clrThrshld=" + this.clrThrshld +
			'}';
		}
	}

	/*********************** Builder Implementation of NonFinancialInstitutionSector10__2  ***********************/
	class NonFinancialInstitutionSector10__2BuilderImpl implements NonFinancialInstitutionSector10__2.NonFinancialInstitutionSector10__2Builder {
	
		protected List<GenericIdentification175__1.GenericIdentification175__1Builder> sctr = new ArrayList<>();
		protected Boolean clrThrshld;
		
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
		
		@RosettaAttribute("sctr")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("sctr")
		@Override
		public NonFinancialInstitutionSector10__2.NonFinancialInstitutionSector10__2Builder addSctr(GenericIdentification175__1 _sctr) {
			if (_sctr != null) {
				this.sctr.add(_sctr.toBuilder());
			}
			return this;
		}
		
		@Override
		public NonFinancialInstitutionSector10__2.NonFinancialInstitutionSector10__2Builder addSctr(GenericIdentification175__1 _sctr, int idx) {
			getIndex(this.sctr, idx, () -> _sctr.toBuilder());
			return this;
		}
		
		@Override
		public NonFinancialInstitutionSector10__2.NonFinancialInstitutionSector10__2Builder addSctr(List<? extends GenericIdentification175__1> sctrs) {
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
		public NonFinancialInstitutionSector10__2.NonFinancialInstitutionSector10__2Builder setSctr(List<? extends GenericIdentification175__1> sctrs) {
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
		public NonFinancialInstitutionSector10__2.NonFinancialInstitutionSector10__2Builder setClrThrshld(Boolean _clrThrshld) {
			this.clrThrshld = _clrThrshld == null ? null : _clrThrshld;
			return this;
		}
		
		@Override
		public NonFinancialInstitutionSector10__2 build() {
			return new NonFinancialInstitutionSector10__2.NonFinancialInstitutionSector10__2Impl(this);
		}
		
		@Override
		public NonFinancialInstitutionSector10__2.NonFinancialInstitutionSector10__2Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NonFinancialInstitutionSector10__2.NonFinancialInstitutionSector10__2Builder prune() {
			sctr = sctr.stream().filter(b->b!=null).<GenericIdentification175__1.GenericIdentification175__1Builder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
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
		public NonFinancialInstitutionSector10__2.NonFinancialInstitutionSector10__2Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			NonFinancialInstitutionSector10__2.NonFinancialInstitutionSector10__2Builder o = (NonFinancialInstitutionSector10__2.NonFinancialInstitutionSector10__2Builder) other;
			
			merger.mergeRosetta(getSctr(), o.getSctr(), this::getOrCreateSctr);
			
			merger.mergeBasic(getClrThrshld(), o.getClrThrshld(), this::setClrThrshld);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			NonFinancialInstitutionSector10__2 _that = getType().cast(o);
		
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
			return "NonFinancialInstitutionSector10__2Builder {" +
				"sctr=" + this.sctr + ", " +
				"clrThrshld=" + this.clrThrshld +
			'}';
		}
	}
}
