package iso20022.auth030.esma;

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
import iso20022.auth030.esma.meta.PriceData2__1Meta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * Indicates the details of the price applicable to the derivative transaction.
 * @version ${project.version}
 */
@RosettaDataType(value="PriceData2__1", builder=PriceData2__1.PriceData2__1BuilderImpl.class, version="${project.version}")
@RuneDataType(value="PriceData2__1", model="iso20022", builder=PriceData2__1.PriceData2__1BuilderImpl.class, version="${project.version}")
public interface PriceData2__1 extends RosettaModelObject {

	PriceData2__1Meta metaData = new PriceData2__1Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Indicates the price per derivative excluding, where applicable: fees, taxes or commissions.
	 */
	SecuritiesTransactionPrice17Choice__1 getPric();
	/**
	 * Specifies the effective date and end date of the schedule for derivative transactions with prices varying throughout the life of the transaction.
	 */
	List<? extends Schedule1> getSchdlPrd();

	/*********************** Build Methods  ***********************/
	PriceData2__1 build();
	
	PriceData2__1.PriceData2__1Builder toBuilder();
	
	static PriceData2__1.PriceData2__1Builder builder() {
		return new PriceData2__1.PriceData2__1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PriceData2__1> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends PriceData2__1> getType() {
		return PriceData2__1.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("pric"), processor, SecuritiesTransactionPrice17Choice__1.class, getPric());
		processRosetta(path.newSubPath("schdlPrd"), processor, Schedule1.class, getSchdlPrd());
	}
	

	/*********************** Builder Interface  ***********************/
	interface PriceData2__1Builder extends PriceData2__1, RosettaModelObjectBuilder {
		SecuritiesTransactionPrice17Choice__1.SecuritiesTransactionPrice17Choice__1Builder getOrCreatePric();
		@Override
		SecuritiesTransactionPrice17Choice__1.SecuritiesTransactionPrice17Choice__1Builder getPric();
		Schedule1.Schedule1Builder getOrCreateSchdlPrd(int index);
		@Override
		List<? extends Schedule1.Schedule1Builder> getSchdlPrd();
		PriceData2__1.PriceData2__1Builder setPric(SecuritiesTransactionPrice17Choice__1 pric);
		PriceData2__1.PriceData2__1Builder addSchdlPrd(Schedule1 schdlPrd);
		PriceData2__1.PriceData2__1Builder addSchdlPrd(Schedule1 schdlPrd, int idx);
		PriceData2__1.PriceData2__1Builder addSchdlPrd(List<? extends Schedule1> schdlPrd);
		PriceData2__1.PriceData2__1Builder setSchdlPrd(List<? extends Schedule1> schdlPrd);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("pric"), processor, SecuritiesTransactionPrice17Choice__1.SecuritiesTransactionPrice17Choice__1Builder.class, getPric());
			processRosetta(path.newSubPath("schdlPrd"), processor, Schedule1.Schedule1Builder.class, getSchdlPrd());
		}
		

		PriceData2__1.PriceData2__1Builder prune();
	}

	/*********************** Immutable Implementation of PriceData2__1  ***********************/
	class PriceData2__1Impl implements PriceData2__1 {
		private final SecuritiesTransactionPrice17Choice__1 pric;
		private final List<? extends Schedule1> schdlPrd;
		
		protected PriceData2__1Impl(PriceData2__1.PriceData2__1Builder builder) {
			this.pric = ofNullable(builder.getPric()).map(f->f.build()).orElse(null);
			this.schdlPrd = ofNullable(builder.getSchdlPrd()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("pric")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("pric")
		public SecuritiesTransactionPrice17Choice__1 getPric() {
			return pric;
		}
		
		@Override
		@RosettaAttribute("schdlPrd")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("schdlPrd")
		public List<? extends Schedule1> getSchdlPrd() {
			return schdlPrd;
		}
		
		@Override
		public PriceData2__1 build() {
			return this;
		}
		
		@Override
		public PriceData2__1.PriceData2__1Builder toBuilder() {
			PriceData2__1.PriceData2__1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PriceData2__1.PriceData2__1Builder builder) {
			ofNullable(getPric()).ifPresent(builder::setPric);
			ofNullable(getSchdlPrd()).ifPresent(builder::setSchdlPrd);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PriceData2__1 _that = getType().cast(o);
		
			if (!Objects.equals(pric, _that.getPric())) return false;
			if (!ListEquals.listEquals(schdlPrd, _that.getSchdlPrd())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (pric != null ? pric.hashCode() : 0);
			_result = 31 * _result + (schdlPrd != null ? schdlPrd.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PriceData2__1 {" +
				"pric=" + this.pric + ", " +
				"schdlPrd=" + this.schdlPrd +
			'}';
		}
	}

	/*********************** Builder Implementation of PriceData2__1  ***********************/
	class PriceData2__1BuilderImpl implements PriceData2__1.PriceData2__1Builder {
	
		protected SecuritiesTransactionPrice17Choice__1.SecuritiesTransactionPrice17Choice__1Builder pric;
		protected List<Schedule1.Schedule1Builder> schdlPrd = new ArrayList<>();
		
		@Override
		@RosettaAttribute("pric")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("pric")
		public SecuritiesTransactionPrice17Choice__1.SecuritiesTransactionPrice17Choice__1Builder getPric() {
			return pric;
		}
		
		@Override
		public SecuritiesTransactionPrice17Choice__1.SecuritiesTransactionPrice17Choice__1Builder getOrCreatePric() {
			SecuritiesTransactionPrice17Choice__1.SecuritiesTransactionPrice17Choice__1Builder result;
			if (pric!=null) {
				result = pric;
			}
			else {
				result = pric = SecuritiesTransactionPrice17Choice__1.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("schdlPrd")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("schdlPrd")
		public List<? extends Schedule1.Schedule1Builder> getSchdlPrd() {
			return schdlPrd;
		}
		
		@Override
		public Schedule1.Schedule1Builder getOrCreateSchdlPrd(int index) {
			if (schdlPrd==null) {
				this.schdlPrd = new ArrayList<>();
			}
			return getIndex(schdlPrd, index, () -> {
						Schedule1.Schedule1Builder newSchdlPrd = Schedule1.builder();
						return newSchdlPrd;
					});
		}
		
		@RosettaAttribute("pric")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("pric")
		@Override
		public PriceData2__1.PriceData2__1Builder setPric(SecuritiesTransactionPrice17Choice__1 _pric) {
			this.pric = _pric == null ? null : _pric.toBuilder();
			return this;
		}
		
		@RosettaAttribute("schdlPrd")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("schdlPrd")
		@Override
		public PriceData2__1.PriceData2__1Builder addSchdlPrd(Schedule1 _schdlPrd) {
			if (_schdlPrd != null) {
				this.schdlPrd.add(_schdlPrd.toBuilder());
			}
			return this;
		}
		
		@Override
		public PriceData2__1.PriceData2__1Builder addSchdlPrd(Schedule1 _schdlPrd, int idx) {
			getIndex(this.schdlPrd, idx, () -> _schdlPrd.toBuilder());
			return this;
		}
		
		@Override
		public PriceData2__1.PriceData2__1Builder addSchdlPrd(List<? extends Schedule1> schdlPrds) {
			if (schdlPrds != null) {
				for (final Schedule1 toAdd : schdlPrds) {
					this.schdlPrd.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("schdlPrd")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("schdlPrd")
		@Override
		public PriceData2__1.PriceData2__1Builder setSchdlPrd(List<? extends Schedule1> schdlPrds) {
			if (schdlPrds == null) {
				this.schdlPrd = new ArrayList<>();
			} else {
				this.schdlPrd = schdlPrds.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public PriceData2__1 build() {
			return new PriceData2__1.PriceData2__1Impl(this);
		}
		
		@Override
		public PriceData2__1.PriceData2__1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PriceData2__1.PriceData2__1Builder prune() {
			if (pric!=null && !pric.prune().hasData()) pric = null;
			schdlPrd = schdlPrd.stream().filter(b->b!=null).<Schedule1.Schedule1Builder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPric()!=null && getPric().hasData()) return true;
			if (getSchdlPrd()!=null && getSchdlPrd().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PriceData2__1.PriceData2__1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PriceData2__1.PriceData2__1Builder o = (PriceData2__1.PriceData2__1Builder) other;
			
			merger.mergeRosetta(getPric(), o.getPric(), this::setPric);
			merger.mergeRosetta(getSchdlPrd(), o.getSchdlPrd(), this::getOrCreateSchdlPrd);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PriceData2__1 _that = getType().cast(o);
		
			if (!Objects.equals(pric, _that.getPric())) return false;
			if (!ListEquals.listEquals(schdlPrd, _that.getSchdlPrd())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (pric != null ? pric.hashCode() : 0);
			_result = 31 * _result + (schdlPrd != null ? schdlPrd.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PriceData2__1Builder {" +
				"pric=" + this.pric + ", " +
				"schdlPrd=" + this.schdlPrd +
			'}';
		}
	}
}
