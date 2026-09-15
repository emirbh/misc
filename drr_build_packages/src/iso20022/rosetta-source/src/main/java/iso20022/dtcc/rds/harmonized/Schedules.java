package iso20022.dtcc.rds.harmonized;

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
import iso20022.dtcc.rds.harmonized.meta.SchedulesMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="Schedules", builder=Schedules.SchedulesBuilderImpl.class, version="${project.version}")
@RuneDataType(value="Schedules", model="iso20022", builder=Schedules.SchedulesBuilderImpl.class, version="${project.version}")
public interface Schedules extends RosettaModelObject {

	SchedulesMeta metaData = new SchedulesMeta();

	/*********************** Getter Methods  ***********************/
	List<? extends CdeSchedule1> getCdeNotionalSchedule1();
	List<? extends CdeSchedule2> getCdeNotionalSchedule2();
	List<? extends CdePriceSchedule> getCdePriceSchedule();
	List<? extends CdeStrikePriceSchedule> getCdeStrikePriceSchedule();

	/*********************** Build Methods  ***********************/
	Schedules build();
	
	Schedules.SchedulesBuilder toBuilder();
	
	static Schedules.SchedulesBuilder builder() {
		return new Schedules.SchedulesBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Schedules> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends Schedules> getType() {
		return Schedules.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("cdeNotionalSchedule1"), processor, CdeSchedule1.class, getCdeNotionalSchedule1());
		processRosetta(path.newSubPath("cdeNotionalSchedule2"), processor, CdeSchedule2.class, getCdeNotionalSchedule2());
		processRosetta(path.newSubPath("cdePriceSchedule"), processor, CdePriceSchedule.class, getCdePriceSchedule());
		processRosetta(path.newSubPath("cdeStrikePriceSchedule"), processor, CdeStrikePriceSchedule.class, getCdeStrikePriceSchedule());
	}
	

	/*********************** Builder Interface  ***********************/
	interface SchedulesBuilder extends Schedules, RosettaModelObjectBuilder {
		CdeSchedule1.CdeSchedule1Builder getOrCreateCdeNotionalSchedule1(int index);
		@Override
		List<? extends CdeSchedule1.CdeSchedule1Builder> getCdeNotionalSchedule1();
		CdeSchedule2.CdeSchedule2Builder getOrCreateCdeNotionalSchedule2(int index);
		@Override
		List<? extends CdeSchedule2.CdeSchedule2Builder> getCdeNotionalSchedule2();
		CdePriceSchedule.CdePriceScheduleBuilder getOrCreateCdePriceSchedule(int index);
		@Override
		List<? extends CdePriceSchedule.CdePriceScheduleBuilder> getCdePriceSchedule();
		CdeStrikePriceSchedule.CdeStrikePriceScheduleBuilder getOrCreateCdeStrikePriceSchedule(int index);
		@Override
		List<? extends CdeStrikePriceSchedule.CdeStrikePriceScheduleBuilder> getCdeStrikePriceSchedule();
		Schedules.SchedulesBuilder addCdeNotionalSchedule1(CdeSchedule1 cdeNotionalSchedule1);
		Schedules.SchedulesBuilder addCdeNotionalSchedule1(CdeSchedule1 cdeNotionalSchedule1, int idx);
		Schedules.SchedulesBuilder addCdeNotionalSchedule1(List<? extends CdeSchedule1> cdeNotionalSchedule1);
		Schedules.SchedulesBuilder setCdeNotionalSchedule1(List<? extends CdeSchedule1> cdeNotionalSchedule1);
		Schedules.SchedulesBuilder addCdeNotionalSchedule2(CdeSchedule2 cdeNotionalSchedule2);
		Schedules.SchedulesBuilder addCdeNotionalSchedule2(CdeSchedule2 cdeNotionalSchedule2, int idx);
		Schedules.SchedulesBuilder addCdeNotionalSchedule2(List<? extends CdeSchedule2> cdeNotionalSchedule2);
		Schedules.SchedulesBuilder setCdeNotionalSchedule2(List<? extends CdeSchedule2> cdeNotionalSchedule2);
		Schedules.SchedulesBuilder addCdePriceSchedule(CdePriceSchedule cdePriceSchedule);
		Schedules.SchedulesBuilder addCdePriceSchedule(CdePriceSchedule cdePriceSchedule, int idx);
		Schedules.SchedulesBuilder addCdePriceSchedule(List<? extends CdePriceSchedule> cdePriceSchedule);
		Schedules.SchedulesBuilder setCdePriceSchedule(List<? extends CdePriceSchedule> cdePriceSchedule);
		Schedules.SchedulesBuilder addCdeStrikePriceSchedule(CdeStrikePriceSchedule cdeStrikePriceSchedule);
		Schedules.SchedulesBuilder addCdeStrikePriceSchedule(CdeStrikePriceSchedule cdeStrikePriceSchedule, int idx);
		Schedules.SchedulesBuilder addCdeStrikePriceSchedule(List<? extends CdeStrikePriceSchedule> cdeStrikePriceSchedule);
		Schedules.SchedulesBuilder setCdeStrikePriceSchedule(List<? extends CdeStrikePriceSchedule> cdeStrikePriceSchedule);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("cdeNotionalSchedule1"), processor, CdeSchedule1.CdeSchedule1Builder.class, getCdeNotionalSchedule1());
			processRosetta(path.newSubPath("cdeNotionalSchedule2"), processor, CdeSchedule2.CdeSchedule2Builder.class, getCdeNotionalSchedule2());
			processRosetta(path.newSubPath("cdePriceSchedule"), processor, CdePriceSchedule.CdePriceScheduleBuilder.class, getCdePriceSchedule());
			processRosetta(path.newSubPath("cdeStrikePriceSchedule"), processor, CdeStrikePriceSchedule.CdeStrikePriceScheduleBuilder.class, getCdeStrikePriceSchedule());
		}
		

		Schedules.SchedulesBuilder prune();
	}

	/*********************** Immutable Implementation of Schedules  ***********************/
	class SchedulesImpl implements Schedules {
		private final List<? extends CdeSchedule1> cdeNotionalSchedule1;
		private final List<? extends CdeSchedule2> cdeNotionalSchedule2;
		private final List<? extends CdePriceSchedule> cdePriceSchedule;
		private final List<? extends CdeStrikePriceSchedule> cdeStrikePriceSchedule;
		
		protected SchedulesImpl(Schedules.SchedulesBuilder builder) {
			this.cdeNotionalSchedule1 = ofNullable(builder.getCdeNotionalSchedule1()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.cdeNotionalSchedule2 = ofNullable(builder.getCdeNotionalSchedule2()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.cdePriceSchedule = ofNullable(builder.getCdePriceSchedule()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.cdeStrikePriceSchedule = ofNullable(builder.getCdeStrikePriceSchedule()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("cdeNotionalSchedule1")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("cdeNotionalSchedule1")
		public List<? extends CdeSchedule1> getCdeNotionalSchedule1() {
			return cdeNotionalSchedule1;
		}
		
		@Override
		@RosettaAttribute("cdeNotionalSchedule2")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("cdeNotionalSchedule2")
		public List<? extends CdeSchedule2> getCdeNotionalSchedule2() {
			return cdeNotionalSchedule2;
		}
		
		@Override
		@RosettaAttribute("cdePriceSchedule")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("cdePriceSchedule")
		public List<? extends CdePriceSchedule> getCdePriceSchedule() {
			return cdePriceSchedule;
		}
		
		@Override
		@RosettaAttribute("cdeStrikePriceSchedule")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("cdeStrikePriceSchedule")
		public List<? extends CdeStrikePriceSchedule> getCdeStrikePriceSchedule() {
			return cdeStrikePriceSchedule;
		}
		
		@Override
		public Schedules build() {
			return this;
		}
		
		@Override
		public Schedules.SchedulesBuilder toBuilder() {
			Schedules.SchedulesBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Schedules.SchedulesBuilder builder) {
			ofNullable(getCdeNotionalSchedule1()).ifPresent(builder::setCdeNotionalSchedule1);
			ofNullable(getCdeNotionalSchedule2()).ifPresent(builder::setCdeNotionalSchedule2);
			ofNullable(getCdePriceSchedule()).ifPresent(builder::setCdePriceSchedule);
			ofNullable(getCdeStrikePriceSchedule()).ifPresent(builder::setCdeStrikePriceSchedule);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Schedules _that = getType().cast(o);
		
			if (!ListEquals.listEquals(cdeNotionalSchedule1, _that.getCdeNotionalSchedule1())) return false;
			if (!ListEquals.listEquals(cdeNotionalSchedule2, _that.getCdeNotionalSchedule2())) return false;
			if (!ListEquals.listEquals(cdePriceSchedule, _that.getCdePriceSchedule())) return false;
			if (!ListEquals.listEquals(cdeStrikePriceSchedule, _that.getCdeStrikePriceSchedule())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (cdeNotionalSchedule1 != null ? cdeNotionalSchedule1.hashCode() : 0);
			_result = 31 * _result + (cdeNotionalSchedule2 != null ? cdeNotionalSchedule2.hashCode() : 0);
			_result = 31 * _result + (cdePriceSchedule != null ? cdePriceSchedule.hashCode() : 0);
			_result = 31 * _result + (cdeStrikePriceSchedule != null ? cdeStrikePriceSchedule.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Schedules {" +
				"cdeNotionalSchedule1=" + this.cdeNotionalSchedule1 + ", " +
				"cdeNotionalSchedule2=" + this.cdeNotionalSchedule2 + ", " +
				"cdePriceSchedule=" + this.cdePriceSchedule + ", " +
				"cdeStrikePriceSchedule=" + this.cdeStrikePriceSchedule +
			'}';
		}
	}

	/*********************** Builder Implementation of Schedules  ***********************/
	class SchedulesBuilderImpl implements Schedules.SchedulesBuilder {
	
		protected List<CdeSchedule1.CdeSchedule1Builder> cdeNotionalSchedule1 = new ArrayList<>();
		protected List<CdeSchedule2.CdeSchedule2Builder> cdeNotionalSchedule2 = new ArrayList<>();
		protected List<CdePriceSchedule.CdePriceScheduleBuilder> cdePriceSchedule = new ArrayList<>();
		protected List<CdeStrikePriceSchedule.CdeStrikePriceScheduleBuilder> cdeStrikePriceSchedule = new ArrayList<>();
		
		@Override
		@RosettaAttribute("cdeNotionalSchedule1")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("cdeNotionalSchedule1")
		public List<? extends CdeSchedule1.CdeSchedule1Builder> getCdeNotionalSchedule1() {
			return cdeNotionalSchedule1;
		}
		
		@Override
		public CdeSchedule1.CdeSchedule1Builder getOrCreateCdeNotionalSchedule1(int index) {
			if (cdeNotionalSchedule1==null) {
				this.cdeNotionalSchedule1 = new ArrayList<>();
			}
			return getIndex(cdeNotionalSchedule1, index, () -> {
						CdeSchedule1.CdeSchedule1Builder newCdeNotionalSchedule1 = CdeSchedule1.builder();
						return newCdeNotionalSchedule1;
					});
		}
		
		@Override
		@RosettaAttribute("cdeNotionalSchedule2")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("cdeNotionalSchedule2")
		public List<? extends CdeSchedule2.CdeSchedule2Builder> getCdeNotionalSchedule2() {
			return cdeNotionalSchedule2;
		}
		
		@Override
		public CdeSchedule2.CdeSchedule2Builder getOrCreateCdeNotionalSchedule2(int index) {
			if (cdeNotionalSchedule2==null) {
				this.cdeNotionalSchedule2 = new ArrayList<>();
			}
			return getIndex(cdeNotionalSchedule2, index, () -> {
						CdeSchedule2.CdeSchedule2Builder newCdeNotionalSchedule2 = CdeSchedule2.builder();
						return newCdeNotionalSchedule2;
					});
		}
		
		@Override
		@RosettaAttribute("cdePriceSchedule")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("cdePriceSchedule")
		public List<? extends CdePriceSchedule.CdePriceScheduleBuilder> getCdePriceSchedule() {
			return cdePriceSchedule;
		}
		
		@Override
		public CdePriceSchedule.CdePriceScheduleBuilder getOrCreateCdePriceSchedule(int index) {
			if (cdePriceSchedule==null) {
				this.cdePriceSchedule = new ArrayList<>();
			}
			return getIndex(cdePriceSchedule, index, () -> {
						CdePriceSchedule.CdePriceScheduleBuilder newCdePriceSchedule = CdePriceSchedule.builder();
						return newCdePriceSchedule;
					});
		}
		
		@Override
		@RosettaAttribute("cdeStrikePriceSchedule")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("cdeStrikePriceSchedule")
		public List<? extends CdeStrikePriceSchedule.CdeStrikePriceScheduleBuilder> getCdeStrikePriceSchedule() {
			return cdeStrikePriceSchedule;
		}
		
		@Override
		public CdeStrikePriceSchedule.CdeStrikePriceScheduleBuilder getOrCreateCdeStrikePriceSchedule(int index) {
			if (cdeStrikePriceSchedule==null) {
				this.cdeStrikePriceSchedule = new ArrayList<>();
			}
			return getIndex(cdeStrikePriceSchedule, index, () -> {
						CdeStrikePriceSchedule.CdeStrikePriceScheduleBuilder newCdeStrikePriceSchedule = CdeStrikePriceSchedule.builder();
						return newCdeStrikePriceSchedule;
					});
		}
		
		@RosettaAttribute("cdeNotionalSchedule1")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("cdeNotionalSchedule1")
		@Override
		public Schedules.SchedulesBuilder addCdeNotionalSchedule1(CdeSchedule1 _cdeNotionalSchedule1) {
			if (_cdeNotionalSchedule1 != null) {
				this.cdeNotionalSchedule1.add(_cdeNotionalSchedule1.toBuilder());
			}
			return this;
		}
		
		@Override
		public Schedules.SchedulesBuilder addCdeNotionalSchedule1(CdeSchedule1 _cdeNotionalSchedule1, int idx) {
			getIndex(this.cdeNotionalSchedule1, idx, () -> _cdeNotionalSchedule1.toBuilder());
			return this;
		}
		
		@Override
		public Schedules.SchedulesBuilder addCdeNotionalSchedule1(List<? extends CdeSchedule1> cdeNotionalSchedule1s) {
			if (cdeNotionalSchedule1s != null) {
				for (final CdeSchedule1 toAdd : cdeNotionalSchedule1s) {
					this.cdeNotionalSchedule1.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("cdeNotionalSchedule1")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("cdeNotionalSchedule1")
		@Override
		public Schedules.SchedulesBuilder setCdeNotionalSchedule1(List<? extends CdeSchedule1> cdeNotionalSchedule1s) {
			if (cdeNotionalSchedule1s == null) {
				this.cdeNotionalSchedule1 = new ArrayList<>();
			} else {
				this.cdeNotionalSchedule1 = cdeNotionalSchedule1s.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("cdeNotionalSchedule2")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("cdeNotionalSchedule2")
		@Override
		public Schedules.SchedulesBuilder addCdeNotionalSchedule2(CdeSchedule2 _cdeNotionalSchedule2) {
			if (_cdeNotionalSchedule2 != null) {
				this.cdeNotionalSchedule2.add(_cdeNotionalSchedule2.toBuilder());
			}
			return this;
		}
		
		@Override
		public Schedules.SchedulesBuilder addCdeNotionalSchedule2(CdeSchedule2 _cdeNotionalSchedule2, int idx) {
			getIndex(this.cdeNotionalSchedule2, idx, () -> _cdeNotionalSchedule2.toBuilder());
			return this;
		}
		
		@Override
		public Schedules.SchedulesBuilder addCdeNotionalSchedule2(List<? extends CdeSchedule2> cdeNotionalSchedule2s) {
			if (cdeNotionalSchedule2s != null) {
				for (final CdeSchedule2 toAdd : cdeNotionalSchedule2s) {
					this.cdeNotionalSchedule2.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("cdeNotionalSchedule2")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("cdeNotionalSchedule2")
		@Override
		public Schedules.SchedulesBuilder setCdeNotionalSchedule2(List<? extends CdeSchedule2> cdeNotionalSchedule2s) {
			if (cdeNotionalSchedule2s == null) {
				this.cdeNotionalSchedule2 = new ArrayList<>();
			} else {
				this.cdeNotionalSchedule2 = cdeNotionalSchedule2s.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("cdePriceSchedule")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("cdePriceSchedule")
		@Override
		public Schedules.SchedulesBuilder addCdePriceSchedule(CdePriceSchedule _cdePriceSchedule) {
			if (_cdePriceSchedule != null) {
				this.cdePriceSchedule.add(_cdePriceSchedule.toBuilder());
			}
			return this;
		}
		
		@Override
		public Schedules.SchedulesBuilder addCdePriceSchedule(CdePriceSchedule _cdePriceSchedule, int idx) {
			getIndex(this.cdePriceSchedule, idx, () -> _cdePriceSchedule.toBuilder());
			return this;
		}
		
		@Override
		public Schedules.SchedulesBuilder addCdePriceSchedule(List<? extends CdePriceSchedule> cdePriceSchedules) {
			if (cdePriceSchedules != null) {
				for (final CdePriceSchedule toAdd : cdePriceSchedules) {
					this.cdePriceSchedule.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("cdePriceSchedule")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("cdePriceSchedule")
		@Override
		public Schedules.SchedulesBuilder setCdePriceSchedule(List<? extends CdePriceSchedule> cdePriceSchedules) {
			if (cdePriceSchedules == null) {
				this.cdePriceSchedule = new ArrayList<>();
			} else {
				this.cdePriceSchedule = cdePriceSchedules.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("cdeStrikePriceSchedule")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("cdeStrikePriceSchedule")
		@Override
		public Schedules.SchedulesBuilder addCdeStrikePriceSchedule(CdeStrikePriceSchedule _cdeStrikePriceSchedule) {
			if (_cdeStrikePriceSchedule != null) {
				this.cdeStrikePriceSchedule.add(_cdeStrikePriceSchedule.toBuilder());
			}
			return this;
		}
		
		@Override
		public Schedules.SchedulesBuilder addCdeStrikePriceSchedule(CdeStrikePriceSchedule _cdeStrikePriceSchedule, int idx) {
			getIndex(this.cdeStrikePriceSchedule, idx, () -> _cdeStrikePriceSchedule.toBuilder());
			return this;
		}
		
		@Override
		public Schedules.SchedulesBuilder addCdeStrikePriceSchedule(List<? extends CdeStrikePriceSchedule> cdeStrikePriceSchedules) {
			if (cdeStrikePriceSchedules != null) {
				for (final CdeStrikePriceSchedule toAdd : cdeStrikePriceSchedules) {
					this.cdeStrikePriceSchedule.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("cdeStrikePriceSchedule")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("cdeStrikePriceSchedule")
		@Override
		public Schedules.SchedulesBuilder setCdeStrikePriceSchedule(List<? extends CdeStrikePriceSchedule> cdeStrikePriceSchedules) {
			if (cdeStrikePriceSchedules == null) {
				this.cdeStrikePriceSchedule = new ArrayList<>();
			} else {
				this.cdeStrikePriceSchedule = cdeStrikePriceSchedules.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public Schedules build() {
			return new Schedules.SchedulesImpl(this);
		}
		
		@Override
		public Schedules.SchedulesBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Schedules.SchedulesBuilder prune() {
			cdeNotionalSchedule1 = cdeNotionalSchedule1.stream().filter(b->b!=null).<CdeSchedule1.CdeSchedule1Builder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			cdeNotionalSchedule2 = cdeNotionalSchedule2.stream().filter(b->b!=null).<CdeSchedule2.CdeSchedule2Builder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			cdePriceSchedule = cdePriceSchedule.stream().filter(b->b!=null).<CdePriceSchedule.CdePriceScheduleBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			cdeStrikePriceSchedule = cdeStrikePriceSchedule.stream().filter(b->b!=null).<CdeStrikePriceSchedule.CdeStrikePriceScheduleBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCdeNotionalSchedule1()!=null && getCdeNotionalSchedule1().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getCdeNotionalSchedule2()!=null && getCdeNotionalSchedule2().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getCdePriceSchedule()!=null && getCdePriceSchedule().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getCdeStrikePriceSchedule()!=null && getCdeStrikePriceSchedule().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Schedules.SchedulesBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Schedules.SchedulesBuilder o = (Schedules.SchedulesBuilder) other;
			
			merger.mergeRosetta(getCdeNotionalSchedule1(), o.getCdeNotionalSchedule1(), this::getOrCreateCdeNotionalSchedule1);
			merger.mergeRosetta(getCdeNotionalSchedule2(), o.getCdeNotionalSchedule2(), this::getOrCreateCdeNotionalSchedule2);
			merger.mergeRosetta(getCdePriceSchedule(), o.getCdePriceSchedule(), this::getOrCreateCdePriceSchedule);
			merger.mergeRosetta(getCdeStrikePriceSchedule(), o.getCdeStrikePriceSchedule(), this::getOrCreateCdeStrikePriceSchedule);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Schedules _that = getType().cast(o);
		
			if (!ListEquals.listEquals(cdeNotionalSchedule1, _that.getCdeNotionalSchedule1())) return false;
			if (!ListEquals.listEquals(cdeNotionalSchedule2, _that.getCdeNotionalSchedule2())) return false;
			if (!ListEquals.listEquals(cdePriceSchedule, _that.getCdePriceSchedule())) return false;
			if (!ListEquals.listEquals(cdeStrikePriceSchedule, _that.getCdeStrikePriceSchedule())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (cdeNotionalSchedule1 != null ? cdeNotionalSchedule1.hashCode() : 0);
			_result = 31 * _result + (cdeNotionalSchedule2 != null ? cdeNotionalSchedule2.hashCode() : 0);
			_result = 31 * _result + (cdePriceSchedule != null ? cdePriceSchedule.hashCode() : 0);
			_result = 31 * _result + (cdeStrikePriceSchedule != null ? cdeStrikePriceSchedule.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SchedulesBuilder {" +
				"cdeNotionalSchedule1=" + this.cdeNotionalSchedule1 + ", " +
				"cdeNotionalSchedule2=" + this.cdeNotionalSchedule2 + ", " +
				"cdePriceSchedule=" + this.cdePriceSchedule + ", " +
				"cdeStrikePriceSchedule=" + this.cdeStrikePriceSchedule +
			'}';
		}
	}
}
