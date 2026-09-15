package drr.regulation.common;

import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.Multi;
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
import drr.regulation.common.meta.CorporateSectorMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * Specifies the corporate sector of the counterparty.
 * @version 7.7.0
 */
@RosettaDataType(value="CorporateSector", builder=CorporateSector.CorporateSectorBuilderImpl.class, version="7.7.0")
@RuneDataType(value="CorporateSector", model="drr", builder=CorporateSector.CorporateSectorBuilderImpl.class, version="7.7.0")
public interface CorporateSector extends RosettaModelObject {

	CorporateSectorMeta metaData = new CorporateSectorMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Specifies the ESMA EMIR Financial Sector of a counterparty.
	 */
	List<FinancialSectorEnum> getFinancialSector();
	/**
	 * Specifies the ESMA EMIR Non Financial Sector of a counterparty.
	 */
	List<? extends NonFinancialSector> getNonFinancialSector();

	/*********************** Build Methods  ***********************/
	CorporateSector build();
	
	CorporateSector.CorporateSectorBuilder toBuilder();
	
	static CorporateSector.CorporateSectorBuilder builder() {
		return new CorporateSector.CorporateSectorBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CorporateSector> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CorporateSector> getType() {
		return CorporateSector.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("financialSector"), FinancialSectorEnum.class, getFinancialSector(), this);
		processRosetta(path.newSubPath("nonFinancialSector"), processor, NonFinancialSector.class, getNonFinancialSector());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CorporateSectorBuilder extends CorporateSector, RosettaModelObjectBuilder {
		NonFinancialSector.NonFinancialSectorBuilder getOrCreateNonFinancialSector(int index);
		@Override
		List<? extends NonFinancialSector.NonFinancialSectorBuilder> getNonFinancialSector();
		CorporateSector.CorporateSectorBuilder addFinancialSector(FinancialSectorEnum financialSector);
		CorporateSector.CorporateSectorBuilder addFinancialSector(FinancialSectorEnum financialSector, int idx);
		CorporateSector.CorporateSectorBuilder addFinancialSector(List<FinancialSectorEnum> financialSector);
		CorporateSector.CorporateSectorBuilder setFinancialSector(List<FinancialSectorEnum> financialSector);
		CorporateSector.CorporateSectorBuilder addNonFinancialSector(NonFinancialSector nonFinancialSector);
		CorporateSector.CorporateSectorBuilder addNonFinancialSector(NonFinancialSector nonFinancialSector, int idx);
		CorporateSector.CorporateSectorBuilder addNonFinancialSector(List<? extends NonFinancialSector> nonFinancialSector);
		CorporateSector.CorporateSectorBuilder setNonFinancialSector(List<? extends NonFinancialSector> nonFinancialSector);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("financialSector"), FinancialSectorEnum.class, getFinancialSector(), this);
			processRosetta(path.newSubPath("nonFinancialSector"), processor, NonFinancialSector.NonFinancialSectorBuilder.class, getNonFinancialSector());
		}
		

		CorporateSector.CorporateSectorBuilder prune();
	}

	/*********************** Immutable Implementation of CorporateSector  ***********************/
	class CorporateSectorImpl implements CorporateSector {
		private final List<FinancialSectorEnum> financialSector;
		private final List<? extends NonFinancialSector> nonFinancialSector;
		
		protected CorporateSectorImpl(CorporateSector.CorporateSectorBuilder builder) {
			this.financialSector = ofNullable(builder.getFinancialSector()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.nonFinancialSector = ofNullable(builder.getNonFinancialSector()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("financialSector")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("financialSector")
		public List<FinancialSectorEnum> getFinancialSector() {
			return financialSector;
		}
		
		@Override
		@RosettaAttribute("nonFinancialSector")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("nonFinancialSector")
		public List<? extends NonFinancialSector> getNonFinancialSector() {
			return nonFinancialSector;
		}
		
		@Override
		public CorporateSector build() {
			return this;
		}
		
		@Override
		public CorporateSector.CorporateSectorBuilder toBuilder() {
			CorporateSector.CorporateSectorBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CorporateSector.CorporateSectorBuilder builder) {
			ofNullable(getFinancialSector()).ifPresent(builder::setFinancialSector);
			ofNullable(getNonFinancialSector()).ifPresent(builder::setNonFinancialSector);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CorporateSector _that = getType().cast(o);
		
			if (!ListEquals.listEquals(financialSector, _that.getFinancialSector())) return false;
			if (!ListEquals.listEquals(nonFinancialSector, _that.getNonFinancialSector())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (financialSector != null ? financialSector.stream().map(Object::getClass).map(Class::getName).mapToInt(String::hashCode).sum() : 0);
			_result = 31 * _result + (nonFinancialSector != null ? nonFinancialSector.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CorporateSector {" +
				"financialSector=" + this.financialSector + ", " +
				"nonFinancialSector=" + this.nonFinancialSector +
			'}';
		}
	}

	/*********************** Builder Implementation of CorporateSector  ***********************/
	class CorporateSectorBuilderImpl implements CorporateSector.CorporateSectorBuilder {
	
		protected List<FinancialSectorEnum> financialSector = new ArrayList<>();
		protected List<NonFinancialSector.NonFinancialSectorBuilder> nonFinancialSector = new ArrayList<>();
		
		@Override
		@RosettaAttribute("financialSector")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("financialSector")
		public List<FinancialSectorEnum> getFinancialSector() {
			return financialSector;
		}
		
		@Override
		@RosettaAttribute("nonFinancialSector")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("nonFinancialSector")
		public List<? extends NonFinancialSector.NonFinancialSectorBuilder> getNonFinancialSector() {
			return nonFinancialSector;
		}
		
		@Override
		public NonFinancialSector.NonFinancialSectorBuilder getOrCreateNonFinancialSector(int index) {
			if (nonFinancialSector==null) {
				this.nonFinancialSector = new ArrayList<>();
			}
			return getIndex(nonFinancialSector, index, () -> {
						NonFinancialSector.NonFinancialSectorBuilder newNonFinancialSector = NonFinancialSector.builder();
						return newNonFinancialSector;
					});
		}
		
		@RosettaAttribute("financialSector")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("financialSector")
		@Override
		public CorporateSector.CorporateSectorBuilder addFinancialSector(FinancialSectorEnum _financialSector) {
			if (_financialSector != null) {
				this.financialSector.add(_financialSector);
			}
			return this;
		}
		
		@Override
		public CorporateSector.CorporateSectorBuilder addFinancialSector(FinancialSectorEnum _financialSector, int idx) {
			getIndex(this.financialSector, idx, () -> _financialSector);
			return this;
		}
		
		@Override
		public CorporateSector.CorporateSectorBuilder addFinancialSector(List<FinancialSectorEnum> financialSectors) {
			if (financialSectors != null) {
				for (final FinancialSectorEnum toAdd : financialSectors) {
					this.financialSector.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("financialSector")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("financialSector")
		@Override
		public CorporateSector.CorporateSectorBuilder setFinancialSector(List<FinancialSectorEnum> financialSectors) {
			if (financialSectors == null) {
				this.financialSector = new ArrayList<>();
			} else {
				this.financialSector = financialSectors.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("nonFinancialSector")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("nonFinancialSector")
		@Override
		public CorporateSector.CorporateSectorBuilder addNonFinancialSector(NonFinancialSector _nonFinancialSector) {
			if (_nonFinancialSector != null) {
				this.nonFinancialSector.add(_nonFinancialSector.toBuilder());
			}
			return this;
		}
		
		@Override
		public CorporateSector.CorporateSectorBuilder addNonFinancialSector(NonFinancialSector _nonFinancialSector, int idx) {
			getIndex(this.nonFinancialSector, idx, () -> _nonFinancialSector.toBuilder());
			return this;
		}
		
		@Override
		public CorporateSector.CorporateSectorBuilder addNonFinancialSector(List<? extends NonFinancialSector> nonFinancialSectors) {
			if (nonFinancialSectors != null) {
				for (final NonFinancialSector toAdd : nonFinancialSectors) {
					this.nonFinancialSector.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("nonFinancialSector")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("nonFinancialSector")
		@Override
		public CorporateSector.CorporateSectorBuilder setNonFinancialSector(List<? extends NonFinancialSector> nonFinancialSectors) {
			if (nonFinancialSectors == null) {
				this.nonFinancialSector = new ArrayList<>();
			} else {
				this.nonFinancialSector = nonFinancialSectors.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public CorporateSector build() {
			return new CorporateSector.CorporateSectorImpl(this);
		}
		
		@Override
		public CorporateSector.CorporateSectorBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CorporateSector.CorporateSectorBuilder prune() {
			nonFinancialSector = nonFinancialSector.stream().filter(b->b!=null).<NonFinancialSector.NonFinancialSectorBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getFinancialSector()!=null && !getFinancialSector().isEmpty()) return true;
			if (getNonFinancialSector()!=null && getNonFinancialSector().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CorporateSector.CorporateSectorBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CorporateSector.CorporateSectorBuilder o = (CorporateSector.CorporateSectorBuilder) other;
			
			merger.mergeRosetta(getNonFinancialSector(), o.getNonFinancialSector(), this::getOrCreateNonFinancialSector);
			
			merger.mergeBasic(getFinancialSector(), o.getFinancialSector(), (Consumer<FinancialSectorEnum>) this::addFinancialSector);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CorporateSector _that = getType().cast(o);
		
			if (!ListEquals.listEquals(financialSector, _that.getFinancialSector())) return false;
			if (!ListEquals.listEquals(nonFinancialSector, _that.getNonFinancialSector())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (financialSector != null ? financialSector.stream().map(Object::getClass).map(Class::getName).mapToInt(String::hashCode).sum() : 0);
			_result = 31 * _result + (nonFinancialSector != null ? nonFinancialSector.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CorporateSectorBuilder {" +
				"financialSector=" + this.financialSector + ", " +
				"nonFinancialSector=" + this.nonFinancialSector +
			'}';
		}
	}
}
