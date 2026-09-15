package iso20022.auth030.esma;

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
import iso20022.auth030.esma.meta.NotionalAmount6__1Meta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * Indicates the reference amount from which contractual payments are determined and the schedule applicable to the payments.
 * @version ${project.version}
 */
@RosettaDataType(value="NotionalAmount6__1", builder=NotionalAmount6__1.NotionalAmount6__1BuilderImpl.class, version="${project.version}")
@RuneDataType(value="NotionalAmount6__1", model="iso20022", builder=NotionalAmount6__1.NotionalAmount6__1BuilderImpl.class, version="${project.version}")
public interface NotionalAmount6__1 extends RosettaModelObject {

	NotionalAmount6__1Meta metaData = new NotionalAmount6__1Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Reference amount from which contractual payments are determined.  Usage: In case of partial terminations, and amortisations and in case of contracts where the notional, due to the characteristics of the contract, varies over time, it shall reflect the remaining notional after the change took place.
	 */
	AmountAndDirection106__2 getAmt();
	/**
	 * Specifies the effective date and end date of the schedule for derivative transactions negotiated in monetary amounts varying throughout the life of the transaction.
	 */
	List<? extends Schedule11__1> getSchdlPrd();

	/*********************** Build Methods  ***********************/
	NotionalAmount6__1 build();
	
	NotionalAmount6__1.NotionalAmount6__1Builder toBuilder();
	
	static NotionalAmount6__1.NotionalAmount6__1Builder builder() {
		return new NotionalAmount6__1.NotionalAmount6__1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends NotionalAmount6__1> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends NotionalAmount6__1> getType() {
		return NotionalAmount6__1.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("amt"), processor, AmountAndDirection106__2.class, getAmt());
		processRosetta(path.newSubPath("schdlPrd"), processor, Schedule11__1.class, getSchdlPrd());
	}
	

	/*********************** Builder Interface  ***********************/
	interface NotionalAmount6__1Builder extends NotionalAmount6__1, RosettaModelObjectBuilder {
		AmountAndDirection106__2.AmountAndDirection106__2Builder getOrCreateAmt();
		@Override
		AmountAndDirection106__2.AmountAndDirection106__2Builder getAmt();
		Schedule11__1.Schedule11__1Builder getOrCreateSchdlPrd(int index);
		@Override
		List<? extends Schedule11__1.Schedule11__1Builder> getSchdlPrd();
		NotionalAmount6__1.NotionalAmount6__1Builder setAmt(AmountAndDirection106__2 amt);
		NotionalAmount6__1.NotionalAmount6__1Builder addSchdlPrd(Schedule11__1 schdlPrd);
		NotionalAmount6__1.NotionalAmount6__1Builder addSchdlPrd(Schedule11__1 schdlPrd, int idx);
		NotionalAmount6__1.NotionalAmount6__1Builder addSchdlPrd(List<? extends Schedule11__1> schdlPrd);
		NotionalAmount6__1.NotionalAmount6__1Builder setSchdlPrd(List<? extends Schedule11__1> schdlPrd);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("amt"), processor, AmountAndDirection106__2.AmountAndDirection106__2Builder.class, getAmt());
			processRosetta(path.newSubPath("schdlPrd"), processor, Schedule11__1.Schedule11__1Builder.class, getSchdlPrd());
		}
		

		NotionalAmount6__1.NotionalAmount6__1Builder prune();
	}

	/*********************** Immutable Implementation of NotionalAmount6__1  ***********************/
	class NotionalAmount6__1Impl implements NotionalAmount6__1 {
		private final AmountAndDirection106__2 amt;
		private final List<? extends Schedule11__1> schdlPrd;
		
		protected NotionalAmount6__1Impl(NotionalAmount6__1.NotionalAmount6__1Builder builder) {
			this.amt = ofNullable(builder.getAmt()).map(f->f.build()).orElse(null);
			this.schdlPrd = ofNullable(builder.getSchdlPrd()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("amt")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("amt")
		public AmountAndDirection106__2 getAmt() {
			return amt;
		}
		
		@Override
		@RosettaAttribute("schdlPrd")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("schdlPrd")
		public List<? extends Schedule11__1> getSchdlPrd() {
			return schdlPrd;
		}
		
		@Override
		public NotionalAmount6__1 build() {
			return this;
		}
		
		@Override
		public NotionalAmount6__1.NotionalAmount6__1Builder toBuilder() {
			NotionalAmount6__1.NotionalAmount6__1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(NotionalAmount6__1.NotionalAmount6__1Builder builder) {
			ofNullable(getAmt()).ifPresent(builder::setAmt);
			ofNullable(getSchdlPrd()).ifPresent(builder::setSchdlPrd);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			NotionalAmount6__1 _that = getType().cast(o);
		
			if (!Objects.equals(amt, _that.getAmt())) return false;
			if (!ListEquals.listEquals(schdlPrd, _that.getSchdlPrd())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (amt != null ? amt.hashCode() : 0);
			_result = 31 * _result + (schdlPrd != null ? schdlPrd.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "NotionalAmount6__1 {" +
				"amt=" + this.amt + ", " +
				"schdlPrd=" + this.schdlPrd +
			'}';
		}
	}

	/*********************** Builder Implementation of NotionalAmount6__1  ***********************/
	class NotionalAmount6__1BuilderImpl implements NotionalAmount6__1.NotionalAmount6__1Builder {
	
		protected AmountAndDirection106__2.AmountAndDirection106__2Builder amt;
		protected List<Schedule11__1.Schedule11__1Builder> schdlPrd = new ArrayList<>();
		
		@Override
		@RosettaAttribute("amt")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("amt")
		public AmountAndDirection106__2.AmountAndDirection106__2Builder getAmt() {
			return amt;
		}
		
		@Override
		public AmountAndDirection106__2.AmountAndDirection106__2Builder getOrCreateAmt() {
			AmountAndDirection106__2.AmountAndDirection106__2Builder result;
			if (amt!=null) {
				result = amt;
			}
			else {
				result = amt = AmountAndDirection106__2.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("schdlPrd")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("schdlPrd")
		public List<? extends Schedule11__1.Schedule11__1Builder> getSchdlPrd() {
			return schdlPrd;
		}
		
		@Override
		public Schedule11__1.Schedule11__1Builder getOrCreateSchdlPrd(int index) {
			if (schdlPrd==null) {
				this.schdlPrd = new ArrayList<>();
			}
			return getIndex(schdlPrd, index, () -> {
						Schedule11__1.Schedule11__1Builder newSchdlPrd = Schedule11__1.builder();
						return newSchdlPrd;
					});
		}
		
		@RosettaAttribute("amt")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("amt")
		@Override
		public NotionalAmount6__1.NotionalAmount6__1Builder setAmt(AmountAndDirection106__2 _amt) {
			this.amt = _amt == null ? null : _amt.toBuilder();
			return this;
		}
		
		@RosettaAttribute("schdlPrd")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("schdlPrd")
		@Override
		public NotionalAmount6__1.NotionalAmount6__1Builder addSchdlPrd(Schedule11__1 _schdlPrd) {
			if (_schdlPrd != null) {
				this.schdlPrd.add(_schdlPrd.toBuilder());
			}
			return this;
		}
		
		@Override
		public NotionalAmount6__1.NotionalAmount6__1Builder addSchdlPrd(Schedule11__1 _schdlPrd, int idx) {
			getIndex(this.schdlPrd, idx, () -> _schdlPrd.toBuilder());
			return this;
		}
		
		@Override
		public NotionalAmount6__1.NotionalAmount6__1Builder addSchdlPrd(List<? extends Schedule11__1> schdlPrds) {
			if (schdlPrds != null) {
				for (final Schedule11__1 toAdd : schdlPrds) {
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
		public NotionalAmount6__1.NotionalAmount6__1Builder setSchdlPrd(List<? extends Schedule11__1> schdlPrds) {
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
		public NotionalAmount6__1 build() {
			return new NotionalAmount6__1.NotionalAmount6__1Impl(this);
		}
		
		@Override
		public NotionalAmount6__1.NotionalAmount6__1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NotionalAmount6__1.NotionalAmount6__1Builder prune() {
			if (amt!=null && !amt.prune().hasData()) amt = null;
			schdlPrd = schdlPrd.stream().filter(b->b!=null).<Schedule11__1.Schedule11__1Builder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAmt()!=null && getAmt().hasData()) return true;
			if (getSchdlPrd()!=null && getSchdlPrd().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NotionalAmount6__1.NotionalAmount6__1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			NotionalAmount6__1.NotionalAmount6__1Builder o = (NotionalAmount6__1.NotionalAmount6__1Builder) other;
			
			merger.mergeRosetta(getAmt(), o.getAmt(), this::setAmt);
			merger.mergeRosetta(getSchdlPrd(), o.getSchdlPrd(), this::getOrCreateSchdlPrd);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			NotionalAmount6__1 _that = getType().cast(o);
		
			if (!Objects.equals(amt, _that.getAmt())) return false;
			if (!ListEquals.listEquals(schdlPrd, _that.getSchdlPrd())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (amt != null ? amt.hashCode() : 0);
			_result = 31 * _result + (schdlPrd != null ? schdlPrd.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "NotionalAmount6__1Builder {" +
				"amt=" + this.amt + ", " +
				"schdlPrd=" + this.schdlPrd +
			'}';
		}
	}
}
