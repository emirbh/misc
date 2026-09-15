package iso20022.auth030.fca;

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
import iso20022.auth030.fca.meta.TradeConfirmation1ChoiceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Information regarding the confirmation of the contract.
 * @version ${project.version}
 */
@RosettaDataType(value="TradeConfirmation1Choice", builder=TradeConfirmation1Choice.TradeConfirmation1ChoiceBuilderImpl.class, version="${project.version}")
@RuneDataType(value="TradeConfirmation1Choice", model="iso20022", builder=TradeConfirmation1Choice.TradeConfirmation1ChoiceBuilderImpl.class, version="${project.version}")
public interface TradeConfirmation1Choice extends RosettaModelObject {

	TradeConfirmation1ChoiceMeta metaData = new TradeConfirmation1ChoiceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Indicates the type of contract confirmation.
	 */
	TradeConfirmation2 getConfd();
	/**
	 * Indicates that contract was not confirmed.
	 */
	TradeNonConfirmation1 getNonConfd();

	/*********************** Build Methods  ***********************/
	TradeConfirmation1Choice build();
	
	TradeConfirmation1Choice.TradeConfirmation1ChoiceBuilder toBuilder();
	
	static TradeConfirmation1Choice.TradeConfirmation1ChoiceBuilder builder() {
		return new TradeConfirmation1Choice.TradeConfirmation1ChoiceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TradeConfirmation1Choice> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends TradeConfirmation1Choice> getType() {
		return TradeConfirmation1Choice.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("confd"), processor, TradeConfirmation2.class, getConfd());
		processRosetta(path.newSubPath("nonConfd"), processor, TradeNonConfirmation1.class, getNonConfd());
	}
	

	/*********************** Builder Interface  ***********************/
	interface TradeConfirmation1ChoiceBuilder extends TradeConfirmation1Choice, RosettaModelObjectBuilder {
		TradeConfirmation2.TradeConfirmation2Builder getOrCreateConfd();
		@Override
		TradeConfirmation2.TradeConfirmation2Builder getConfd();
		TradeNonConfirmation1.TradeNonConfirmation1Builder getOrCreateNonConfd();
		@Override
		TradeNonConfirmation1.TradeNonConfirmation1Builder getNonConfd();
		TradeConfirmation1Choice.TradeConfirmation1ChoiceBuilder setConfd(TradeConfirmation2 confd);
		TradeConfirmation1Choice.TradeConfirmation1ChoiceBuilder setNonConfd(TradeNonConfirmation1 nonConfd);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("confd"), processor, TradeConfirmation2.TradeConfirmation2Builder.class, getConfd());
			processRosetta(path.newSubPath("nonConfd"), processor, TradeNonConfirmation1.TradeNonConfirmation1Builder.class, getNonConfd());
		}
		

		TradeConfirmation1Choice.TradeConfirmation1ChoiceBuilder prune();
	}

	/*********************** Immutable Implementation of TradeConfirmation1Choice  ***********************/
	class TradeConfirmation1ChoiceImpl implements TradeConfirmation1Choice {
		private final TradeConfirmation2 confd;
		private final TradeNonConfirmation1 nonConfd;
		
		protected TradeConfirmation1ChoiceImpl(TradeConfirmation1Choice.TradeConfirmation1ChoiceBuilder builder) {
			this.confd = ofNullable(builder.getConfd()).map(f->f.build()).orElse(null);
			this.nonConfd = ofNullable(builder.getNonConfd()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("confd")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("confd")
		public TradeConfirmation2 getConfd() {
			return confd;
		}
		
		@Override
		@RosettaAttribute("nonConfd")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("nonConfd")
		public TradeNonConfirmation1 getNonConfd() {
			return nonConfd;
		}
		
		@Override
		public TradeConfirmation1Choice build() {
			return this;
		}
		
		@Override
		public TradeConfirmation1Choice.TradeConfirmation1ChoiceBuilder toBuilder() {
			TradeConfirmation1Choice.TradeConfirmation1ChoiceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TradeConfirmation1Choice.TradeConfirmation1ChoiceBuilder builder) {
			ofNullable(getConfd()).ifPresent(builder::setConfd);
			ofNullable(getNonConfd()).ifPresent(builder::setNonConfd);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeConfirmation1Choice _that = getType().cast(o);
		
			if (!Objects.equals(confd, _that.getConfd())) return false;
			if (!Objects.equals(nonConfd, _that.getNonConfd())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (confd != null ? confd.hashCode() : 0);
			_result = 31 * _result + (nonConfd != null ? nonConfd.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeConfirmation1Choice {" +
				"confd=" + this.confd + ", " +
				"nonConfd=" + this.nonConfd +
			'}';
		}
	}

	/*********************** Builder Implementation of TradeConfirmation1Choice  ***********************/
	class TradeConfirmation1ChoiceBuilderImpl implements TradeConfirmation1Choice.TradeConfirmation1ChoiceBuilder {
	
		protected TradeConfirmation2.TradeConfirmation2Builder confd;
		protected TradeNonConfirmation1.TradeNonConfirmation1Builder nonConfd;
		
		@Override
		@RosettaAttribute("confd")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("confd")
		public TradeConfirmation2.TradeConfirmation2Builder getConfd() {
			return confd;
		}
		
		@Override
		public TradeConfirmation2.TradeConfirmation2Builder getOrCreateConfd() {
			TradeConfirmation2.TradeConfirmation2Builder result;
			if (confd!=null) {
				result = confd;
			}
			else {
				result = confd = TradeConfirmation2.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("nonConfd")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("nonConfd")
		public TradeNonConfirmation1.TradeNonConfirmation1Builder getNonConfd() {
			return nonConfd;
		}
		
		@Override
		public TradeNonConfirmation1.TradeNonConfirmation1Builder getOrCreateNonConfd() {
			TradeNonConfirmation1.TradeNonConfirmation1Builder result;
			if (nonConfd!=null) {
				result = nonConfd;
			}
			else {
				result = nonConfd = TradeNonConfirmation1.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("confd")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("confd")
		@Override
		public TradeConfirmation1Choice.TradeConfirmation1ChoiceBuilder setConfd(TradeConfirmation2 _confd) {
			this.confd = _confd == null ? null : _confd.toBuilder();
			return this;
		}
		
		@RosettaAttribute("nonConfd")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("nonConfd")
		@Override
		public TradeConfirmation1Choice.TradeConfirmation1ChoiceBuilder setNonConfd(TradeNonConfirmation1 _nonConfd) {
			this.nonConfd = _nonConfd == null ? null : _nonConfd.toBuilder();
			return this;
		}
		
		@Override
		public TradeConfirmation1Choice build() {
			return new TradeConfirmation1Choice.TradeConfirmation1ChoiceImpl(this);
		}
		
		@Override
		public TradeConfirmation1Choice.TradeConfirmation1ChoiceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeConfirmation1Choice.TradeConfirmation1ChoiceBuilder prune() {
			if (confd!=null && !confd.prune().hasData()) confd = null;
			if (nonConfd!=null && !nonConfd.prune().hasData()) nonConfd = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getConfd()!=null && getConfd().hasData()) return true;
			if (getNonConfd()!=null && getNonConfd().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeConfirmation1Choice.TradeConfirmation1ChoiceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			TradeConfirmation1Choice.TradeConfirmation1ChoiceBuilder o = (TradeConfirmation1Choice.TradeConfirmation1ChoiceBuilder) other;
			
			merger.mergeRosetta(getConfd(), o.getConfd(), this::setConfd);
			merger.mergeRosetta(getNonConfd(), o.getNonConfd(), this::setNonConfd);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeConfirmation1Choice _that = getType().cast(o);
		
			if (!Objects.equals(confd, _that.getConfd())) return false;
			if (!Objects.equals(nonConfd, _that.getNonConfd())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (confd != null ? confd.hashCode() : 0);
			_result = 31 * _result + (nonConfd != null ? nonConfd.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeConfirmation1ChoiceBuilder {" +
				"confd=" + this.confd + ", " +
				"nonConfd=" + this.nonConfd +
			'}';
		}
	}
}
